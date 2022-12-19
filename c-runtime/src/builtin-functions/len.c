#include "builtin-functions/len.h"

#include <stdio.h>
#include <assert.h>

#include "mpy_obj.h"
#include "errors.h"
#include "function-args.h"
#include "literals/list.h"
#include "literals/tuple.h"
#include "builtins-setup.h"
#include "type-hierarchy/type.h"

__MPyObj* __mpy_func_len(__MPyObj *args, __MPyObj *kwargs) {
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("len", args, kwargs, 1);
    __MPyObj *obj = __mpy_args_get_positional(&argHelper, 0, "obj");
    __mpy_args_finish(&argHelper);

    __MPyObj *result = __mpy_call(__mpy_obj_get_attr(obj, "__len__"), __mpy_obj_init_tuple(0), NULL);
    __mpy_obj_ref_dec(obj);

    return __mpy_obj_return(result);
}

