package com.foton.common.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by ZY
 */
public class BaseResponse<T>  implements Serializable {
    public String code="-1";
    public String msg;
    public int error=-1;
    public String result="";
    public T data;
    public String failNum;
    public String recordCount;
    public String totalMoney;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean success() {
        return "0".equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSucceed(){
        if(code.equals("0")||error==0||result.equals("0"))
            return true;
        else
            return false;
    }
}
