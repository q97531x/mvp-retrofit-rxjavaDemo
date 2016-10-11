package com.example.mvpdraggerretrofit.Base;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 啄木鸟 on 15/11/7.
 * 基本返回类型
 */
public class ArrayResponse<E> implements Serializable {
    private boolean success;
    private String message;
    private String msgCode;
    private int addAccount;
    private ArrayList<E> value;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getAddAccount() {
        return addAccount;
    }

    public void setAddAccount(int addAccount) {
        this.addAccount = addAccount;
    }

    public ArrayList<E> getValue() {
        return value;
    }

    public void setValue(ArrayList<E> value) {
        this.value = value;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }
}
