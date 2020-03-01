package com.hoodee.book.result;

/**
 * Package: com.hoodee.book.result
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 15:54
 * Modified By:
 */

public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
