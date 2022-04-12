package com.example.persistencialogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        txtNome = findViewById(R.id.txtNome);
        Bundle args = getIntent().getExtras();
        String nome = args.getString("chave_usuario");
        txtNome.setText("Bem vindo "+nome);
    }
}