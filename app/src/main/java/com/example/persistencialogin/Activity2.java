package com.example.persistencialogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private EditText edtNome, edtUsur, edtEmail, edtSenha, edtConf;
    private DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        edtNome=findViewById(R.id.edtNome);
        edtEmail=findViewById(R.id.edtEmail);
        edtUsur=findViewById(R.id.edtUsuario);
        edtSenha=findViewById(R.id.edtSenha);
        edtConf=findViewById(R.id.edtConfSenha);
    }
    public void cadastrar(View view) {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String usuario = edtUsur.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConf.getText().toString();
        if(!senha.equals(confSenha)){
            Toast toast = Toast.makeText(Activity2.this,
                    "Senha diferente da confirmação de senha!",
                    Toast.LENGTH_SHORT);
            toast.show();
            edtSenha.setText("");
            edtConf.setText("");
        }
        else{
            Contato c = new Contato(nome,email,usuario,senha);
            helper.insereContato(c);
            Toast toast = Toast.makeText(Activity2.this,
                    "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            limpar();
            finish();
        }
    }
    private void limpar() {
        edtNome.setText("");
        edtEmail.setText("");
        edtUsur.setText("");
        edtSenha.setText("");
        edtConf.setText("");
    }

    public void cancelar(View view) {
        finish();
    }
}