package com.psp.mvpexample.presenter;

import com.psp.mvpexample.contract.LoginContract;
import com.psp.mvpexample.model.LoginModel;

public class LoginPresenter implements LoginContract.PresenterContract {

    LoginContract.ViewContract viewContract;

    private LoginModel model;


    public LoginPresenter(LoginContract.ViewContract viewContract) {
        this.viewContract = viewContract;
        model = new LoginModel(this);
    }


    @Override
    public void doLogin(String username, String password) {
        viewContract.showProgress();
        model.requestLogin(username,password);
    }

    @Override
    public void loginSuccess() {
        viewContract.loginSuccess();
        viewContract.stopProgress();
    }

    @Override
    public void loginFailed() {
        viewContract.loginFailed();
        viewContract.stopProgress();
    }
}
