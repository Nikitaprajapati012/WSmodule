package com.ecosmob.wsmodule.Utils;

public class Constants {

    /*** Created by nikita on 28/8/17.
     */
    public static final String PREFRENCE = "prefrence";

    public class RequestKey {
        public static final String BASE_URL = "baseUrl";
        public static final String API_NAME = "apiName";
        public static final String METHOD_GET = "methodGet";
        public static final String METHOD_POST = "methodPost";
        public static final String METHOD_DELETE = "methodDelete";
        public static final String EMAIL = "email";
        public static final String DEVICE_TYPE = "devicetype";
        public static final String DEVICE_TOKEN = "devicetoken";
        public static final String PASWD = "password";
    }

    public class APIURL {
        public static final String URL_LOGIN = "https://reqres.in/api/login";
    }

    public class DialogMessage {
        public static final String PLEASE_WAIT = "Please Wait...";
        public static final String NULL_VALUE = "No Data Found";
        public static final String NETWORK_ERROR = "Please Check Your Internet Connection";
        public static final String RESPONSE_ERROR = "JSONException..Something went to wrong";
    }

    public class API_CODE {
        public static final String API_LOGIN = "1";
        public static final String API_REG = "2";
        public static final String API_FORGOT = "3";
    }

}
