package com.psp.mvpexample.model;

import com.psp.mvpexample.contract.LoginContract;

public class LoginModel implements LoginContract.ModelContract {

    private LoginContract.PresenterContract presenter;

    public LoginModel(LoginContract.PresenterContract presenter) {
        this.presenter = presenter;
    }


    @Override
    public void requestLogin(String username, String password) {
        if(username.equals("admin") && password.equals("123")) {
            presenter.loginSuccess();
        } else {
            presenter.loginFailed();
        }
    }
}
