package com.mrc.appentrevista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mrc.appentrevista.api.config.RetrofitConfig;
import com.mrc.appentrevista.api.model.Cliente;
import com.mrc.appentrevista.api.model.Conta;
import com.mrc.appentrevista.component.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacoesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Conta> listacontas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);
        listacontas = new ArrayList<>();
//        recyclerView.setHasFixedSize(true);
        recyclerView = (RecyclerView) findViewById(R.id.listRecyclerview);

        final Call<Cliente> callCliente = new RetrofitConfig().getClientePorId().getClientePorId(String.valueOf(1));
        callCliente.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {

                if (!response.isSuccessful()) {
                    return;
                }
                Cliente cliente = response.body();

                for (Conta conta : cliente.getStatementList()) {
                    Log.i("APP", "Ok " + conta.toString());
                    listacontas.add(conta);
                    inicializarRecicleViewContas(listacontas);
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void inicializarRecicleViewContas(List<Conta> listContas) {
        MyAdapter mAdapter = new MyAdapter(this, listContas);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
