package com.mrc.appentrevista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mrc.appentrevista.util.StringUtil;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText edtlogin, edtsenha;
    private String mensagemApresentacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtlogin = findViewById(R.id.edtlogintxt);
        edtsenha = findViewById(R.id.edtsenhatxt);
        btnEntrar = findViewById(R.id.btnentrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtlogin.getText().toString().isEmpty() && !edtsenha.getText().toString().isEmpty()) {
                    try {


                        if (StringUtil.validacaoSenhaSegura(getApplicationContext(), edtsenha.getText().toString())) {
                            mensagemApresentacao = "Usuário Logado";
                            Intent intent = new Intent(getApplication(), InformacoesActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            mensagemApresentacao = "Os criterios de senha devem ser válidos.";
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "O email ou a senha devem ser preenchidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
