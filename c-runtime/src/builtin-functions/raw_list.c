#include "builtin-functions/raw_list.h"

#include <stdio.h>
#include <assert.h>

#include "mpy_obj.h"
#include "errors.h"
#include "function-args.h"
#include "literals/list.h"

__MPyObj* __mpy_func_raw_list(__MPyObj *args, __MPyObj *kwargs) {
    assert(args != NULL && kwargs != NULL);

    __MPyGetArgsState argHelper = __mpy_args_init("raw_list", args, kwargs, 0);
    __mpy_args_finish(&argHelper);

    __MPyObj *list = __mpy_obj_init_list();

    return __mpy_obj_return(list);
}

