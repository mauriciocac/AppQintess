package com.mrc.appentrevista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mrc.appentrevista.api.config.RetrofitConfig;
import com.mrc.appentrevista.api.model.Cliente;
import com.mrc.appentrevista.api.model.Conta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);
        final Call<Cliente> callCliente = new RetrofitConfig().getClientePorId().getClientePorId(String.valueOf(1));
        callCliente.enqueue(new Callback<Cliente>() {

            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                Cliente d = response.body();

                Toast.makeText(getApplication(), "Cliente: " + d.toString(), Toast.LENGTH_LONG).show();
                Log.i("APP", "Ok " + d.toString());
                for (Conta c : d.getStatementList()) {
                    Log.i("APP", "Ok " + c.toString());
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
