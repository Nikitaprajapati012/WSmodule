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

/** * Created by nikita on 29/8/17.
 */

class BackgroundAsyncTask extends AsyncTask<String, String, String> {
    public Context mContext;
    public String urlResponse, DialogMsg, strURL;
    public HashMap<String, String> stringHashMap;
    public int apiCode;
    public String isPostMethod;
    public ProgressDialog dialog;
    public ApiResponse apiResponse;
    public Utils utils;
    public FragmentManager fragmentManager;

    // TODO: 30/8/17 Bind the required parameter and integrate the API.
    public BackgroundAsyncTask(Context context, HashMap<String, String> hashMapDataParams,
                               String urlResponse, String pleaseWait, int apiCode,
                               String isGetMethod, ApiResponse apiResponse) {
        this.mContext = context;
        this.stringHashMap = hashMapDataParams;
        this.urlResponse = urlResponse;
        this.DialogMsg = pleaseWait;
        this.apiCode = apiCode;
        this.isPostMethod = isGetMethod;
        this.apiResponse = apiResponse;
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
        if (!isPostMethod.equalsIgnoreCase(Constants.URL_METHOD.METHOD_POST)) {
            strURL = Constants.APIURL.URL_LOGIN;
            return Utils.getResponseofGet(strURL);
        } else {
            strURL = Constants.APIURL.URL_LOGIN;
            return Utils.getResponseofPost(strURL, stringHashMap);
        }
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        dialog.dismiss();
        Log.d("RESPONSE", "@@" + response);
        apiResponse.apiResponseCallBack(response, apiCode);
    }
}
