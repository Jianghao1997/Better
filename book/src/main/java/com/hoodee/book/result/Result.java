package com.hoodee.book.result;

import lombok.Data;

/**
 * Package: com.hoodee.book.result
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 15:54
 * Modified By:
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
