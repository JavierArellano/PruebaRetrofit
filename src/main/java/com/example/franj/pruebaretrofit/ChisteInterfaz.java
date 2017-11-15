package com.example.franj.pruebaretrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by franj on 10/11/2017.
 */

public interface ChisteInterfaz {
    @GET("jokes/random")
    Call <Chiste> loadChiste();

    @GET("jokes/random/{numero}")
    Call <ChisteLista> loadChisteLista(@Path("numero") String numero);
}
