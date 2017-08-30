package com.example.nikita.authentication.activity.view;

/*** Created by nikita on 24/8/17.
 */

public interface LoginView extends ContextView {

    void onShowToast(String msg);

    void launchHomeActivity();

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setWrongUsernameError();

    void setPasswordError();

    void setWrongPasswordError();
}
