package com.mhlab.codestyle.common.enums;

/**
 * Created by MHLab on 02/09/2019..
 */

public enum JsonFail {

    //Login
    LOGIN_FAIL("CF-LOGIN-001", "Login fail."),

    //Etc
    ETC("CF-ETC", "Etc msg");


    private String code;
    private String msg;
    JsonFail(String code, String msg) { this.code = code; this.msg = msg; }
    public String code() {return this.code;}
    public String msg() {return this.msg;}
}
