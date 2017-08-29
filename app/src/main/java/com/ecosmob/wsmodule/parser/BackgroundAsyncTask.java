package com.ecosmob.wsmodule.parser;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.ecosmob.wsmodule.Utils.Constants;
import com.ecosmob.wsmodule.Utils.Utils;
import com.ecosmob.wsmodule.interfaces.ApiResponse;

import java.util.HashMap;

/**
 * Created by nikita on 29/8/17.
 */

class BackgroundAsyncTask extends AsyncTask<String, String, String> {
    public Context mContext;
    public String urlResponse, DialogMsg, strURL;
    public HashMap<String, String> stringHashMap;
    public int apiCode;
    public boolean isGetMethod;
    public ProgressDialog dialog;
    public ApiResponse apiResponse;
    public Utils utils;
    public FragmentManager fragmentManager;

    public BackgroundAsyncTask(Context context, HashMap<String, String> hashMapDataParams,
                               String urlResponse, String pleaseWait, int apiCode,
                               boolean isGetMethod
    ) {
        this.mContext = context;
        this.stringHashMap = hashMapDataParams;
        this.urlResponse = urlResponse;
        this.DialogMsg = pleaseWait;
        this.apiCode = apiCode;
        this.isGetMethod = isGetMethod;
        utils = new Utils(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(mContext);
        dialog.setMessage(DialogMsg);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        if (isGetMethod) {
            strURL = Constants.APIURL.URL_LOGIN;
            Utils.getResponseofGet(strURL);
        } else {
            strURL = Constants.APIURL.URL_LOGIN;
            Utils.getResponseofPost(strURL, stringHashMap);
        }
        Log.d("REQUEST_URL", "@@" + strURL);
        return strURL;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        dialog.dismiss();
        Log.d("RESPONSE", "@@" + response);
        apiResponse.apiResponseCallBack(response, apiCode);
    }

    public void execute(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
