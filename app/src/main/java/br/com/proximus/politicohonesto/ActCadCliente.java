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

/**
 * Activity to test a simple CRUD design with validations
 *
 * @author Deividy Pinheiro
 */
public class ActCadCliente extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
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
                Toast.makeText(this, "Button OK Selected", Toast.LENGTH_SHORT).show();
                validaCampos();
                break;
            case R.id.action_cancel:
                Toast.makeText(this, "Button Cancelar Selected", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
