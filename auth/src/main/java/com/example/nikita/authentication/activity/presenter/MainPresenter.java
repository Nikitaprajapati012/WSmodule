package com.example.nikita.authentication.activity.presenter;

import com.example.nikita.authentication.activity.activity.LoginActivity;
import com.example.nikita.authentication.activity.iteractor.LoginInteractor;
import com.example.nikita.authentication.activity.iteractor.LoginInteractorImpl;
import com.example.nikita.authentication.activity.model.UserAthentication;
import com.example.nikita.authentication.activity.view.LoginView;

import java.util.ArrayList;

/*** Created by nikita on 24/8/17.
 */

public class MainPresenter /*implements LoginPresenter, LoginInteractor.OnLoginFinishedListener*/ {
    private Throwable error;
    private LoginActivity view;
    public ArrayList<UserAthentication> items;
    public LoginView loginView;
    public LoginInteractor loginInteractor;

    public MainPresenter(LoginView view) {
        this.loginView = view;
        this.loginInteractor = new LoginInteractorImpl();
    }

    public MainPresenter(LoginActivity view) {
        this.view = view;
    }

//
//    @Override
//    public void onClickSubmit(String email, String password) {
//        if (email != null) {
//            view.onClickSubmit(email, password);
//            ValidateEmail(email);
//            if (password != null) {
//                CheckPassword(password);
//            } else {
//                onShowToast(getApplicationContext().getResources().getString(R.string.pwdempty));
//            }
//        } else {
//            onShowToast(getApplicationContext().getResources().getString(R.string.emailempty));
//        }
//    }
//
//    @Override
//    public void ValidateEmail(String email) {
//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//        if (email.matches(emailPattern) && email.length() > 0) {
//            onShowToast(getApplicationContext().getResources().getString(R.string.validemail));
//        } else {
//            onShowToast(getApplicationContext().getResources().getString(R.string.invalidemail));
//        }
//    }
//
//    @Override
//    public void CheckPassword(String strPassword, String pwd) {
//        if (pwd.equalsIgnoreCase(strPassword)) {
//            onShowToast(getApplicationContext().getResources().getString(R.string.loginsucess));
//            //call the api for login here
//        } else {
//            onShowToast(getApplicationContext().getResources().getString(R.string.validpwd));
//        }
//    }
//
//    @Override
//    public void validateCredentials(String username, String password) {
//        if (loginView != null) {
//            loginView.showProgress();
//        }
//        loginInteractor.login(username, password, this);
//    }
//
//    @Override
//    public void onDestroy() {
//        loginView = null;
//    }
//
//    @Override
//    public void onUsernameError() {
//        if (loginView != null) {
//            loginView.setWrongUsernameError();;
//            loginView.hideProgress();
//        }
//    }
//
//    @Override
//    public void onPasswordError() {
//
//    }
//
//    @Override
//    public void onSuccess() {
//
//    }
}
