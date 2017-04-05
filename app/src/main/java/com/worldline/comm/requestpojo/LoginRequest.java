package com.worldline.comm.requestpojo;


public class LoginRequest {

    private String dasId;
    private String encodedDASPwd;

    public LoginRequest(String dasId, String encodedDASPwd) {
        this.dasId = dasId;
        this.encodedDASPwd = encodedDASPwd;
    }
}
