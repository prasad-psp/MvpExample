package com.psp.mvpexample.contract;

public interface LoginContract {


    interface ViewContract {
        void showProgress();
        void stopProgress();
        void loginSuccess();
        void loginFailed();
    }

    interface PresenterContract {
        void doLogin(String username,String password);
        void loginSuccess();
        void loginFailed();
    }

    interface ModelContract {
        void requestLogin(String username,String password);
    }
}
