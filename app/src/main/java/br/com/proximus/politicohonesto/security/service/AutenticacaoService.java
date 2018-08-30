package br.com.proximus.politicohonesto.security.service;


import br.com.proximus.politicohonesto.security.dto.TokenDto;
import br.com.proximus.politicohonesto.security.Response;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AutenticacaoService {
    @Headers({"Content-Type: application/json"})
    @POST("auth")
    Call<Response<TokenDto>> auth(@Body RequestBody body);
}