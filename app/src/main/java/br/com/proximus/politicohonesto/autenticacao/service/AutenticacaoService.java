package br.com.proximus.politicohonesto.autenticacao.service;


import br.com.proximus.politicohonesto.autenticacao.dto.TokenDto;
import br.com.proximus.politicohonesto.autenticacao.Response;
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