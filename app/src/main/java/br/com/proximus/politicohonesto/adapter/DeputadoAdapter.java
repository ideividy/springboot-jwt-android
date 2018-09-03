package br.com.proximus.politicohonesto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.proximus.politicohonesto.R;
import br.com.proximus.politicohonesto.models.Deputado;

public class DeputadoAdapter extends RecyclerView.Adapter<DeputadoAdapter.ViewHolderDeputado> {

    private List<Deputado> dados;

    public DeputadoAdapter(List<Deputado> dados){
        this.dados = dados;
    }

    @NonNull
    @Override
    public DeputadoAdapter.ViewHolderDeputado onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_deputados, parent, false);

        ViewHolderDeputado holderDeputado = new ViewHolderDeputado(view);

        return holderDeputado;
    }

    @Override
    public void onBindViewHolder(@NonNull DeputadoAdapter.ViewHolderDeputado holder, int position) {
        if(dados != null && !dados.isEmpty()){
            Deputado deputado = dados.get(position);
            holder.txtNome.setText(deputado.getNome());
            holder.txtPartido.setText(deputado.getSiglaPartido());
            Picasso.get().load(deputado.getUrlFoto()).into(holder.imgPhoto);
        }

    }

    @Override
    public int getItemCount() {
        return dados != null ? dados.size() : 0;
    }

    public class ViewHolderDeputado extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtPartido;
        public ImageView imgPhoto;

        public ViewHolderDeputado(View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPartido = itemView.findViewById(R.id.txtPartido);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
        }
    }
}
