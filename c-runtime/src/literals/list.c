#include "literals/list.h"

#include <assert.h>
#include <string.h>

#include "builtins-setup.h"
#include "type-hierarchy/type.h"
#include "checks.h"
#include "errors.h"
#include "function-args.h"
#include "literals/int.h"
#include "literals/boolean.h"
#include "literals/int.h"
#include "type-hierarchy/bound-method.h"

__MPyObj* __mpy_list_set_attr_impl(__MPyObj *self, const char *name, __MPyObj *value) {
    (void)self;
    (void)name;
    (void)value;
    __MPY_TODO("set attr");
}

__MPyObj* __mpy_list_get_attr_impl(__MPyObj *self, const char *name) {
    if (strcmp("__bool__", name) == 0) {
        return ((MPyListContent*) self->content)->boolMethod;
    }
    if (strcmp("__insert__", name) == 0) {
        return ((MPyListContent*) self->content)->insertMethod;
    }
    if (strcmp("__get__", name) == 0) {
        return ((MPyListContent*) self->content)->getMethod;
    }
    if (strcmp("__remove__", name) == 0) {
        return ((MPyListContent*) self->content)->removeMethod;
    }
    if (strcmp("__len__", name) == 0) {
        return ((MPyListContent*) self->content)->lenMethod;
    }
    if (strcmp("__append__", name) == 0) {
        return ((MPyListContent*) self->content)->appendMethod;
    }

    return NULL;
}

void list_cleanup(__MPyObj *self) {
    MPyListContent *content = self->content;
    if(content->next != NULL){
        list_cleanup(content->next);
        __mpy_obj_ref_dec(content->next);
    }
    __mpy_obj_ref_dec(content->value);
    __mpy_obj_ref_dec(content->boolMethod);
    __mpy_obj_ref_dec(content->insertMethod);
    __mpy_obj_ref_dec(content->getMethod);
    __mpy_obj_ref_dec(content->removeMethod);
    __mpy_obj_ref_dec(content->lenMethod);
    __mpy_obj_ref_dec(content->appendMethod);
}

__MPyObj* __mpy_obj_init_list(void) {
    __MPyObj *obj = __mpy_obj_new();
    obj->type = __MPyType_List;
    obj->attrAccessor = __mpy_list_get_attr_impl;
    obj->attrSetter = __mpy_list_set_attr_impl;
    obj->cleanupAction = list_cleanup;

    obj->content = __mpy_checked_malloc(sizeof(MPyListContent));
    MPyListContent *content = (MPyListContent*) obj->content;
    content->value = NULL;
    content->next = NULL;
    content->size = 0;
    
    content->boolMethod = __mpy_bind_func(__MPyFunc_List_bool, obj);
    content->insertMethod = __mpy_bind_func(__MPyFunc_List_insert, obj);
    content->getMethod = __mpy_bind_func(__MPyFunc_List_get, obj);
    content->removeMethod = __mpy_bind_func(__MPyFunc_List_remove, obj);
    content->lenMethod = __mpy_bind_func(__MPyFunc_List_len, obj);
    content->appendMethod = __mpy_bind_func(__MPyFunc_List_append, obj);

    return __mpy_obj_return(obj);
}

__MPyObj* __mpy_list_func_bool_impl(__MPyObj *args, __MPyObj *kwargs) {
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__bool__", args, kwargs, 1);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __mpy_args_finish(&argHelper);

    MPyListContent *content = self->content;

    __mpy_boolean_c_type truth = content->size > 0 ? true : false;

    __mpy_obj_ref_dec(self);
    return __mpy_obj_return(__mpy_obj_init_boolean(truth));
}

void insert_rec(__MPyObj *head, __MPyObj *self, __MPyObj *value, __mpy_int_c_type index, int current_index){
    MPyListContent *content = self->content;
    MPyListContent *head_content = head->content;
    if(self == NULL || index >= head_content->size){
        fprintf(stderr, "IndexOutOfRange: The index %lld is out of range for size %d.\n", index, content->size);
        __mpy_fatal_error(__MPY_ERROR_USER);
    }
    if(current_index != index){
        insert_rec(head, content->next, value, index, current_index+1);
        return;
    }

    __MPyObj *new_node = __mpy_obj_init_list();
    ((MPyListContent *)new_node->content)->value = value;
    MPyListContent *new_node_content = new_node->content;
    new_node_content->next = content->next;
    content->next = new_node;
}

__MPyObj* __mpy_list_func_insert_impl(__MPyObj *args, __MPyObj *kwargs){
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__insert__", args, kwargs, 3);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __MPyObj *value = __mpy_args_get_positional(&argHelper, 1, "value");
    __MPyObj *index = __mpy_args_get_positional(&argHelper, 2, "index");
    __mpy_args_finish(&argHelper);

    if (self->type != __MPyType_List) {
        fprintf(stderr, "TypeError: list.__insert__ cannot be called on type '%s'.\n", __mpy_type_name(self->type));
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    if(index->type != __MPyType_Num){
        fprintf(stderr, "TypeError: index in list.__insert__ has to be an Integer.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    MPyIntContent *int_content = (MPyIntContent*)index->content;
    __mpy_int_c_type index_val = int_content->value;

    if(index_val < 0){
        fprintf(stderr, "RangeError: index must be 0 or above.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    insert_rec(self, self, value, index_val, 0);
    
    MPyListContent *content = self->content;
    content->size++;

    __mpy_obj_ref_dec(index);
    return __mpy_obj_return(value);
}

__MPyObj *get_value_at_index(__MPyObj *head, __MPyObj *self, __mpy_int_c_type index, int current_index){
    MPyListContent *content = self->content;
    MPyListContent *head_content = head->content;
    if(self == NULL || index >= head_content->size){
        fprintf(stderr, "IndexOutOfRange: The index %lld is out of range for size %d.\n", index, content->size);
        __mpy_fatal_error(__MPY_ERROR_USER);
    }
    if(current_index != index){
        return get_value_at_index(head, content->next, index, current_index+1);
    }
    return __mpy_obj_return(content->value);
}

__MPyObj* __mpy_list_func_get_impl(__MPyObj *args, __MPyObj *kwargs){
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__get__", args, kwargs, 2);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __MPyObj *index = __mpy_args_get_positional(&argHelper, 1, "index");
    __mpy_args_finish(&argHelper);

    if (self->type != __MPyType_List) {
        fprintf(stderr, "TypeError: list.__insert__ cannot be called on type '%s'.\n", __mpy_type_name(self->type));
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    if(index->type != __MPyType_Num){
        fprintf(stderr, "TypeError: index in list.__insert__ has to be an Integer.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    MPyIntContent *content = (MPyIntContent*)index->content;
    __mpy_int_c_type index_val = content->value;


    if(index_val < 0){
        fprintf(stderr, "RangeError: index must be 0 or above.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    __MPyObj *value = get_value_at_index(self, self, index_val, 0);

    __mpy_obj_ref_dec(self);
    __mpy_obj_ref_dec(index);
    return __mpy_obj_return(value);
}

void remove_at_index(__MPyObj *head, __MPyObj *self, __mpy_int_c_type index, int current_index){
    MPyListContent *content = self->content;
    MPyListContent *head_content = head->content;
    if(self == NULL || index >= head_content->size){
        fprintf(stderr, "IndexOutOfRange: The index %lld is out of range for size %d.\n", index, content->size);
        __mpy_fatal_error(__MPY_ERROR_USER);
    }
    if(index == 0){
        if(content->next != NULL){
            MPyListContent *next_content = content->next->content;
            content->value = next_content->value;
            __mpy_obj_ref_inc(content->value);
            __MPyObj *next = content->next;
            content->next = next_content->next;
            next_content->next = NULL;
            next->cleanupAction(next);
        } else {
            content->value = NULL;
        }
        return;
    }
    if(current_index-1 != index){
        get_value_at_index(head, content->next, index, current_index+1);
        return;
    }
    if(content->next == NULL){
        MPyListContent *content = head->content;
        fprintf(stderr, "IndexOutOfRange: The index %lld is out of range for size %d.\n", index, content->size);
        __mpy_fatal_error(__MPY_ERROR_USER);
    }
    __MPyObj *next = content->next;
    MPyListContent *next_content = (MPyListContent*)content->next->content;
    if(next_content->next != NULL){
        __MPyObj *next_next = next_content->next;
        content->next = next_next;
    }
    next_content->next = NULL;
    // __mpy_obj_ref_dec(next);
    content->next->cleanupAction(next);
}

__MPyObj* __mpy_list_func_remove_impl(__MPyObj *args, __MPyObj *kwargs){
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__remove__", args, kwargs, 2);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __MPyObj *index = __mpy_args_get_positional(&argHelper, 1, "index");
    __mpy_args_finish(&argHelper);

    if(index->type != __MPyType_Num){
        fprintf(stderr, "TypeError: index in list.__insert__ has to be an Integer.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    MPyIntContent *index_content = (MPyIntContent*)index->content;
    __mpy_int_c_type index_val = index_content->value;

    if(index_val < 0){
        fprintf(stderr, "RangeError: index must be 0 or above.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }

    remove_at_index(self, self, index_val, 0);

    MPyListContent *content = self->content;
    content->size--;

    __mpy_obj_ref_dec(index);
    return __mpy_obj_return(self);
}

__MPyObj* __mpy_list_func_len_impl(__MPyObj *args, __MPyObj *kwargs){
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__len__", args, kwargs, 1);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __mpy_args_finish(&argHelper);

    MPyListContent *content = self->content;

    __mpy_obj_ref_dec(self);
    return __mpy_obj_return(__mpy_obj_init_int(content->size));
}

void append_rec(__MPyObj *self, __MPyObj *value){
    MPyListContent *content = self->content;
    if(self == NULL){
        fprintf(stderr, "NullPointerException: The list to append the element does not exist.\n");
        __mpy_fatal_error(__MPY_ERROR_USER);
    }
    if(content->next != NULL){
        append_rec(content->next, value);
        return;
    }

    if(content->value == NULL){
        content->value = value;
        return;
    }

    __MPyObj *new_node = __mpy_obj_init_list();
    ((MPyListContent *)new_node->content)->value = value;
    ((MPyListContent *)new_node->content)->size += 1;
    MPyListContent *new_node_content = new_node->content;
    new_node_content->next = content->next;
    content->next = new_node;
}

__MPyObj* __mpy_list_func_append_impl(__MPyObj *args, __MPyObj *kwargs){
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("list.__len__", args, kwargs, 2);
    __MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
    __MPyObj *value = __mpy_args_get_positional(&argHelper, 1, "value");
    __mpy_args_finish(&argHelper);

    MPyListContent *content = self->content;

    append_rec(self, value);
    content->size++;

    return __mpy_obj_return(self);
}
