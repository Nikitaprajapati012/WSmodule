package com.ecosmob.wsmodule.activity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ecosmob.wsmodule.R;
import com.ecosmob.wsmodule.Utils.Constants;
import com.ecosmob.wsmodule.Utils.Utils;
import com.ecosmob.wsmodule.interfaces.ApiResponse;
import com.ecosmob.wsmodule.model.JsonRequest;
import com.ecosmob.wsmodule.parser.HTTPApiRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MainActivity extends AppCompatActivity implements ApiResponse {


    public String strEmail, strPasword, strDeviceId, strDeviceType;
    public Utils utils;
    public FragmentManager fragmentManager;
    public EditText edEmail, edPassword;
    public TextView txtLogin;
    public NetworkInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findById();
        clickEventPerform();

        // TODO: 29/8/17 check internet connection
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        Log.d("isConnected", "--" + info.toString());
    }

    // TODO: 29/8/17 perform click event
    private void clickEventPerform() {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                strEmail = edEmail.getText().toString().trim();
                strPasword = edPassword.getText().toString().trim();
                Log.d("VALUES", "@@" + strEmail + "----" + strPasword);
                makeLogin();
            }
        });
    }

    // TODO: 30/8/17 make the login
    private void makeLogin() {
        if (info == null && !info.isConnected()) {
            Toast.makeText(MainActivity.this, "" + Constants.DialogMessage.NETWORK_ERROR, Toast.LENGTH_SHORT).show();
        } else {
            JsonRequest jsonRequest = new JsonRequest();
//                    jsonRequest.setDeviceId(strDeviceId);
//                    jsonRequest.setDeviceType(strDeviceType);
            jsonRequest.setEmail(strEmail);
            jsonRequest.setPassword(strPasword);
            new HTTPApiRequest().loginRequest(MainActivity.this,
                    jsonRequest, Constants.API_CODE.API_LOGIN, this);
        }
    }

    // TODO: 29/8/17 bind id with widget
    private void findById() {
        edEmail = (EditText) findViewById(R.id.activity_main_edemail);
        edPassword = (EditText) findViewById(R.id.activity_main_edpwd);
        txtLogin = (TextView) findViewById(R.id.activity_main_txtlogin);
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        utils = new Utils(MainActivity.this);

        // TODO: 29/8/17 get the device id
        strDeviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d("strDeviceId", "@@" + strDeviceId);

        // TODO: 29/8/17 get the device type
        strDeviceType = "Debug-infos:";
        strDeviceType += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        strDeviceType += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        strDeviceType += "\n Device: " + android.os.Build.DEVICE;
        strDeviceType += "\n Model (and Product): " + android.os.Build.MODEL + " (" + android.os.Build.PRODUCT + ")";
        Log.d("strDeviceType", "@@" + strDeviceType);
    }

    @Override
    public void networkError(int apiCode) {
        Toast.makeText(this, "" + Constants.DialogMessage.NETWORK_ERROR, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void responceError(int apiCode) {
        Toast.makeText(this, "" + Constants.DialogMessage.RESPONSE_ERROR, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void apiResponseCallBack(String urlResponse, int apiCode) {

        try {
            Gson gson = new Gson();
            JsonRequest request = gson.fromJson(urlResponse, JsonRequest.class);

            if (request == null) {
                Toast.makeText(this, "" + Constants.DialogMessage.NULL_VALUE, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "SUCCESS!!", Toast.LENGTH_SHORT).show();
                //write code here for store the response
                //................
            }
        } catch (IllegalStateException | JsonSyntaxException e) {
            e.printStackTrace();
            Log.d("IllegalStateException", "@@" + e.toString());
        } catch (Exception e1) {
            e1.printStackTrace();
            Log.d("Exception", "@@" + e1.toString());
        }
    }
}
