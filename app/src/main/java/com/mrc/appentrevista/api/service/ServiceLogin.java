package com.mrc.appentrevista.api.service;

import com.mrc.appentrevista.api.model.Login;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ServiceLogin {

    @POST("login")
    Call<Login> logarConta(Login login);
}
