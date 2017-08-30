package com.example.nikita.authentication.activity.iteractor;

/*** Created by nikita on 24/8/17.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {

        void onUsernameError();

        void onWrongUsernameError();

        void onPasswordError();

        void onWrongPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
