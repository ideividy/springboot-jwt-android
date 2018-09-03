package br.com.proximus.politicohonesto.security.config;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final static String URL_BASE = "https://lit-river-38977.herokuapp.com/"; /*"http://192.168.1.4:8080/";*///"http://192.168.43.69:8080/";

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

    public Retrofit builderRetrofitAuth(final String token){

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Authorization", "Bearer " +token);
                builder.addHeader("Accept", "text/html");

                return chain.proceed(builder.build());
            }
        });

        return new Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
