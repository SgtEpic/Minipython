#ifndef LITERALS_LIST_H
#define LITERALS_LIST_H

#include "mpy_obj.h"


__MPyObj* __mpy_obj_init_list();

__MPyObj* __mpy_list_func_bool_impl(__MPyObj *args, __MPyObj *kwargs);

__MPyObj* __mpy_list_func_insert_impl(__MPyObj *args, __MPyObj *kwargs);

__MPyObj* __mpy_list_func_get_impl(__MPyObj *args, __MPyObj *kwargs);

__MPyObj* __mpy_list_func_remove_impl(__MPyObj *args, __MPyObj *kwargs);

__MPyObj* __mpy_list_func_len_impl(__MPyObj *args, __MPyObj *kwargs);

__MPyObj* __mpy_list_func_append_impl(__MPyObj *args, __MPyObj *kwargs);


#endif /* LITERALS_LIST_H */

