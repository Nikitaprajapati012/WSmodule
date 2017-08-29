package com.ecosmob.wsmodule.parser;


import android.content.Context;

import com.ecosmob.wsmodule.Utils.Constants;
import com.ecosmob.wsmodule.interfaces.ApiResponse;
import com.ecosmob.wsmodule.model.JsonRequest;

import java.util.HashMap;

/*** Created by nikita on 28/8/17.*/

public class HTTPApiRequest {

    private static HashMap<String, String> hashMapDataParams;

    public static void loginRequest(Context context, JsonRequest req,
                                    int apiCode, ApiResponse apiResponse) {

        hashMapDataParams = new HashMap<>();
        hashMapDataParams.put(Constants.RequestKey.EMAIL, req.getEmail());
        hashMapDataParams.put(Constants.RequestKey.PASWD, req.getPassword());
        //hashMapDataParams.put(Constants.RequestKey.DEVICE_TYPE, req.getDeviceType());
        //hashMapDataParams.put(Constants.RequestKey.DEVICE_TOKEN, req.getDeviceId());

        new BackgroundAsyncTask(context, hashMapDataParams,
                Constants.APIURL.URL_LOGIN,
                Constants.DialogMessage.PLEASE_WAIT, apiCode,
                false).execute(apiResponse);
    }
}
