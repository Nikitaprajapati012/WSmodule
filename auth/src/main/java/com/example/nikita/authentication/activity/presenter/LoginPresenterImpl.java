package com.example.nikita.authentication.activity.presenter;
import com.example.nikita.authentication.activity.iteractor.LoginInteractor;
import com.example.nikita.authentication.activity.iteractor.LoginInteractorImpl;
import com.example.nikita.authentication.activity.view.LoginView;

/*** Created by nikita on 24/8/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);
    }


    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onWrongUsernameError() {
        if (loginView != null) {
            loginView.setWrongUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onWrongPasswordError() {
        if (loginView != null) {
            loginView.setWrongPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.launchHomeActivity();
        }
    }
}
