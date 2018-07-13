package com.z.baselibrary.net;

/**
 * Created by zhangkb on 2017/12/22 0022.
 */

import java.io.Serializable;

public class BaseBean implements Serializable {

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * result : 1
     * message : 操作成功。
     */
    private int  code;
    private String message;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
