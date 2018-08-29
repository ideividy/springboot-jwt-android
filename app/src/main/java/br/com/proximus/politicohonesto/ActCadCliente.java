package br.com.proximus.politicohonesto;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import br.com.proximus.politicohonesto.autenticacao.config.RetrofitConfig;
import br.com.proximus.politicohonesto.autenticacao.service.AutenticacaoService;
import br.com.proximus.politicohonesto.autenticacao.dto.TokenDto;
import br.com.proximus.politicohonesto.autenticacao.Response;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class ActCadCliente extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEndereco;
    private AutenticacaoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);

        service = new RetrofitConfig().buildRetrofit().create(AutenticacaoService.class);

    }

    private void validaCampos(){
        boolean resultado = false;

        String nome = edtNome.getText().toString();
        String endereco = edtEndereco.getText().toString();

        if(isCampoVazio(nome)){
            edtNome.requestFocus();
            resultado = true;
        }else if(isCampoVazio(endereco)){
            edtEndereco.requestFocus();
            resultado = true;
        }

        if(resultado){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.msg_invalid_or_empty);
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    private boolean isCampoVazio(String campo){
        return TextUtils.isEmpty(campo) || campo.trim().isEmpty();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_cliente, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_ok:
                //Toast.makeText(this, "Botão OK Selecionado", Toast.LENGTH_SHORT).show();
                //validaCampos();
                JSONObject jsonObject = new JSONObject();

                /*JwtAuthenticationDto jwt = new JwtAuthenticationDto();
                jwt.setEmail("deividy@gmail.com");
                jwt.setSenha("123456");
*/

                final String json = "{\"email\":\"deividy@gmail.com\", \"senha\":\"123456\"}";
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

                Call<Response<TokenDto>> call = service.auth(body);

                call.enqueue(new Callback<Response<TokenDto>>(){
                    @Override
                    public void onResponse(Call<Response<TokenDto>> call, retrofit2.Response<Response<TokenDto>> response) {
                        TokenDto tokenDto = response.body().getData();
                        System.out.println("TOKEN: " + tokenDto.getToken());
                    }

                    @Override
                    public void onFailure(Call<Response<TokenDto>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

                break;
            case R.id.action_cancel:
                Toast.makeText(this, "Botão Cancelar Selecionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
