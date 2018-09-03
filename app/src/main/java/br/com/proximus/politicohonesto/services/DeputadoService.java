package br.com.proximus.politicohonesto.services;

import java.util.List;
import java.util.Map;

import br.com.proximus.politicohonesto.models.Deputado;
import br.com.proximus.politicohonesto.security.Response;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;


public interface DeputadoService {
    @Headers({"Content-Type: application/json"})
    @GET("/api/deputados/json")
    Call<Response<List<Deputado>>> listarDeputados(@Header("Authorization") String auth);
}
