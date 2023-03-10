package com.ouyu.Utils;

import lombok.Data;

/**
 * @author cdeluser
 */
@Data
public class R {
    private final static int SUCCESS_CODE = 200;
    private final static int ERROR_CODE = -1;

    private int code;
    private String msg;
    private Object data;
    /**
     * 返回方法
     */
    public static R success() {
        R r = new R();
        r.setCode(SUCCESS_CODE);
        return r;
    }
    /**成功时不返回msg*/
    public static R success(Object data) {
        R r = new R();
        r.setCode(SUCCESS_CODE);
        r.setData(data);
        return r;
    }
    public static R success(String msg) {
        R r = new R();
        r.setCode(SUCCESS_CODE);
        r.setMsg(msg);
        return r;
    }
    /**失败时返回-1和msg*/
    public static R error(String msg) {
        R r = new R();
        r.setCode(ERROR_CODE);
        r.setMsg(msg);
        return r;
    }
    /**失败时全都返回*/
    public static R error(int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

}
