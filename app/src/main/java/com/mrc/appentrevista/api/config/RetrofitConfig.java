package com.mrc.appentrevista.api.config;

import com.mrc.appentrevista.api.service.ServiceCliente;
import com.mrc.appentrevista.api.service.ServiceLogin;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final Retrofit instance;

    public RetrofitConfig() {
        instance = new Retrofit.Builder().
                baseUrl("https://bank-app-test.herokuapp.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ServiceLogin logarConta() {
        return this.instance.create(ServiceLogin.class);
    }

    public ServiceCliente getClientePorId() {
        return this.instance.create(ServiceCliente.class);
    }
}
