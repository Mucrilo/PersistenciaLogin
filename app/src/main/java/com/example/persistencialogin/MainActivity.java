package com.example.persistencialogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario, edtSenha;
    private DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtSenha=findViewById(R.id.edtSenha);
    }

    public void conectar(View view) {
        String usr=edtUsuario.getText().toString();
        String senha=edtSenha.getText().toString();
        String pass=helper.buscarSenha(usr);
        if (senha.equals(pass)){
            Intent it=new Intent(MainActivity.this, Activity3.class);
            it.putExtra("chave_usuario", usr);
            startActivity(it);
        }else{
            Toast toast=Toast.makeText(MainActivity.this,
                    "Usuário ou senha inválido!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void cadastrar(View view) {
        Intent it=new Intent(MainActivity.this, Activity2.class);
        startActivity(it);
    }
}