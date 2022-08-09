package com.example.learningapptask.domain;

import com.example.learningapptask.domain.dtoIn.LoginDTOIn;

public class LoginDTO extends LoginDTOIn {

    Boolean isLogin;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password, Boolean isLogin) {
        super(email, password);
        this.isLogin = isLogin;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }
}
