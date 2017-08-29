package com.ecosmob.wsmodule.interfaces;

/*** Created by nikita on 28/8/17.
 */

public interface ApiResponse {

    void networkError(int apiCode);

    void responceError(int apiCode);

    void apiResponseCallBack(String urlResponse, int apiCode);
}
