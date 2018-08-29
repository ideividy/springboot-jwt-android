package br.com.proximus.politicohonesto.autenticacao.config;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final static String URL_BASE = "http://192.168.43.69:8080/";

    public RetrofitConfig(){

    }

    public Retrofit buildRetrofit(){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request();
                Headers headers = request.headers().newBuilder().add("Content-Type", "application/json").build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };
        clientBuilder.addInterceptor(interceptor);

        return new Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
