package com.android.loadingmoredata;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by vishal on 05/07/2016.
 */
public interface InterfaceApi {

    @GET("grocery")
    Call<ResponseData> reg_method();



}
