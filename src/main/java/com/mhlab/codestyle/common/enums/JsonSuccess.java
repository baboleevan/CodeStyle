package com.mhlab.codestyle.common.enums;

/**
 * Created by MHLab on 02/09/2019..
 */

public enum JsonSuccess {

    //Login
    LOGIN_SUCCESS("CS-LOGIN-001", "Login success"),


    //Etc
    ETC("CS-ETC", "Etc msg");

    private String code;
    private String msg;
    JsonSuccess(String code, String msg) { this.code = code; this.msg = msg; }
    public String code() {return this.code;}
    public String msg() {return this.msg;}
}
