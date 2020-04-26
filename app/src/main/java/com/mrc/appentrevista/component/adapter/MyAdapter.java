package com.mrc.appentrevista.component.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrc.appentrevista.R;
import com.mrc.appentrevista.api.model.Conta;
import com.mrc.appentrevista.util.StringUtil;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderConta> {

    private Context context;
    private List<Conta> contas;

    public MyAdapter(Context context, List<Conta> contas) {
        this.context = context;
        this.contas = contas;
    }

    @NonNull
    @Override
    public ViewHolderConta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_conta, parent, false);
        ViewHolderConta holder = new ViewHolderConta(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderConta holder, int position) {
        Log.i("APP", "Clicado");
        holder.descricao.setText(contas.get(position).getDesc());
        holder.valor.setText(StringUtil.marcaraMoeda(contas.get(position).getValue()));
        holder.data.setText(StringUtil.mascaraDataBr(contas.get(position).getDate()));

    }

    @Override
    public int getItemCount() {
        return contas.size();
    }

    public class ViewHolderConta extends RecyclerView.ViewHolder {
        TextView descricao;
        TextView valor;
        TextView data;

        public ViewHolderConta(@NonNull View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.txtpgtoDescricao);
            valor = itemView.findViewById(R.id.txtpgtoValor);
            data = itemView.findViewById(R.id.txtpgtoData);
        }
    }

}
