package com.worldline.comm.webservice.apis;


import com.worldline.comm.Utils.Constant;
import com.worldline.comm.pojo.LoginResponse;
import com.worldline.comm.requestpojo.LoginRequest;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface Login {

    @POST("authenticate")
    Observable<Response<LoginResponse>> userLogin(@Body LoginRequest loginRequest);

}
