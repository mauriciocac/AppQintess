package com.mrc.appentrevista.api.service;

import com.mrc.appentrevista.api.model.Cliente;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceCliente {

    @GET("statements/{idUser}")
    Call<Cliente> getClientePorId(@Path("idUser") String idUser);
}
