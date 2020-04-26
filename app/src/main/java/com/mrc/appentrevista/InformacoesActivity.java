package com.mrc.appentrevista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mrc.appentrevista.api.config.RetrofitConfig;
import com.mrc.appentrevista.api.model.Cliente;
import com.mrc.appentrevista.api.model.Conta;
import com.mrc.appentrevista.component.adapter.MyAdapter;
import com.mrc.appentrevista.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacoesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Conta> listacontas;
    private TextView txtNomeCliente, txtAgenciaCliente, txtContaCliente, txtSaldoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);
        listacontas = new ArrayList<>();
        recyclerView = findViewById(R.id.listRecyclerview);
        txtNomeCliente = findViewById(R.id.txtNomeCliente);
        txtAgenciaCliente = findViewById(R.id.txtAgenciaCliente);
        txtContaCliente = findViewById(R.id.txtContaCliente);
        txtSaldoCliente = findViewById(R.id.txtSaldoCliente);

        Cliente cliente = localizarCliente();

        final Call<Cliente> callCliente = new RetrofitConfig().getClientePorId().getClientePorId(String.valueOf(cliente.getId()));
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

    private Cliente localizarCliente() {

        Cliente cliente = dadosFicticios();

        txtNomeCliente.setText(cliente.getNome());
        txtAgenciaCliente.setText(cliente.getConta());
        txtContaCliente.setText(cliente.getAgencia());
        txtSaldoCliente.setText(StringUtil.marcaraMoeda(cliente.getSaldo()));
        return cliente;
    }

    private Cliente dadosFicticios() {
        Cliente cliente = new Cliente();
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(0, "Mauricio Carvalho", "4567", "10867-9", "11600,00"));
        lista.add(new Cliente(1, "Juliane Mai", "1029", "251624-9", "11500,00"));
        lista.add(new Cliente(2, "Francisco Assis", "7654", "109765-9", "19876,00"));
        lista.add(new Cliente(3, "Simone Ferreira", "1234", "123456-9", "1234,00"));
        int dd = new Random().nextInt(lista.size() - 1);

        for (Cliente c : lista) {
            if (c.getId() == dd) {
                cliente = lista.get(dd);
            }
        }

        return cliente;
    }

    private void inicializarRecicleViewContas(List<Conta> listContas) {
        MyAdapter mAdapter = new MyAdapter(this, listContas);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
