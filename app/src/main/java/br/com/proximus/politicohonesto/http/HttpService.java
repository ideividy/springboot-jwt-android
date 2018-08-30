package br.com.proximus.politicohonesto.http;

import android.os.AsyncTask;

import android.util.Log;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import br.com.proximus.politicohonesto.ActCadCliente;
import br.com.proximus.politicohonesto.models.Deputado;

@Deprecated
public class HttpService extends AsyncTask<String, Void, Deputado> {
    protected static final String TAG = ActCadCliente.class.getSimpleName();
    @Override
    protected Deputado doInBackground(String... strings) {
        try {

            String url = "http://192.168.1.4:8080/api/deputados";
            // Populate the HTTP Basic Authentitcation header with the username and password
            HttpAuthentication authHeader = new HttpBasicAuthentication("deividy@gmail.com", "123456");

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAuthorization(authHeader);
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

            try {
                // Make the network request
                Log.d(TAG, url);
                ResponseEntity<Deputado> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Deputado.class);
                return response.getBody();
            } catch (HttpClientErrorException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
                return null;
            } catch (ResourceAccessException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
                return null;
            }

            //URL url2 = new URL("https://lit-river-38977.herokuapp.com/auth");
            //URL url2 = new URL("http://localhost:8080/auth");

            /*HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "deividy@gmail.com");
            jsonObject.put("senha", "123456");

            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.getOutputStream().write(jsonObject.toString().getBytes());*/

            //URL url = new URL("https://lit-river-38977.herokuapp.com/api/deputados");
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}




