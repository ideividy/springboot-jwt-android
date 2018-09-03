package br.com.proximus.politicohonesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import br.com.proximus.politicohonesto.adapter.DeputadoAdapter;
import br.com.proximus.politicohonesto.controllers.LoggedUserController;
import br.com.proximus.politicohonesto.models.Deputado;
import br.com.proximus.politicohonesto.security.Response;
import br.com.proximus.politicohonesto.security.config.RetrofitConfig;
import br.com.proximus.politicohonesto.security.dto.TokenDto;
import br.com.proximus.politicohonesto.security.service.AutenticacaoService;
import br.com.proximus.politicohonesto.services.DeputadoService;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Activity to test a simple CRUD design with validations
 *
 * @author Deividy Pinheiro
 */
public class ActCadCliente extends AppCompatActivity {

    private DeputadoService deputadoService;
    private RecyclerView lstDados;
    private DeputadoAdapter deputadoAdapter;
    List<Deputado> deputados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstDados = (RecyclerView)findViewById(R.id.listDados);

        lstDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);

    }

    /*private void validaCampos(){
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
    }*/

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
                Toast.makeText(this, "Button OK Selected", Toast.LENGTH_SHORT).show();
                //validaCampos();
                LoggedUserController controller = new LoggedUserController(getBaseContext());
                String token = controller.getTokenByEmail("deividy@gmail.com");

                deputadoService = new RetrofitConfig().builderRetrofitAuth(token).create(DeputadoService.class);

                autenticar("Bearer "+token);
                break;
            case R.id.action_cancel:
                Toast.makeText(this, "Button Cancelar Selected", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void autenticar(String json) {
        //RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        Call<Response<List<Deputado>>> call = deputadoService.listarDeputados(json);

        call.enqueue(new Callback<Response<List<Deputado>>>(){
            @Override
            public void onResponse(Call<Response<List<Deputado>>> call, retrofit2.Response<Response<List<Deputado>>> response) {
                deputados = response.body() != null ? response.body().getData(): null;

                deputadoAdapter = new DeputadoAdapter(deputados);

                lstDados.setAdapter(deputadoAdapter);
            }

            @Override
            public void onFailure(Call<Response<List<Deputado>>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
