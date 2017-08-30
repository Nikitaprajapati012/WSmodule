package com.example.nikita.authentication.activity.iteractor;

import android.content.Context;
import android.text.TextUtils;

import com.example.nikita.authentication.activity.utils.Constants;
import com.example.nikita.authentication.activity.utils.Utils;
import com.example.nikita.authentication.activity.view.ContextView;

/*** Created by nikita on 24/8/17. */

public class LoginInteractorImpl implements LoginInteractor, ContextView {
    private String pass = "aaaa";
    private String email;

    @Override
    public void login(String username,
                      String password,
                      OnLoginFinishedListener listener) {

        boolean statusValidation = false;

        // TODO: 25/8/17 validate the username/email
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                listener.onWrongUsernameError();
            } else {
                email = "nikita@gmail.com";
                Utils.WriteSharedPreference(getApplicationContext(), Constants.USER_EMAILID, email);
                if (!username.matches(Utils.ReadSharedPreference(getApplicationContext(), Constants.USER_EMAILID))) {
                    listener.onWrongUsernameError();
                    statusValidation = true;
                }
            }
        }

        // TODO: 25/8/17 validate the password
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
        } else {
            //match with the right password
            if (!password.matches(pass)) {
                listener.onWrongPasswordError();
                statusValidation = true;
            }

            // TODO: 25/8/17 sucessfully login
            if (!statusValidation) {
                listener.onSuccess();
            }
        }
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }
}
