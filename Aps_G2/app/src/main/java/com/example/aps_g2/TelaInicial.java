package com.example.aps_g2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaInicial extends AppCompatActivity {
    private UsuarioDao bd = new UsuarioDao(this);
    private ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    private ArrayList<String> listaPlaca = new ArrayList<String>();
    private Usuario Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }



        public void cadastrar(View view) {

                EditText cadastraNome = findViewById(R.id.listar);
                if (cadastraNome.getText().toString().equals("")) {
                    Toast.makeText(this, "Digite o nome da Pessoa.", Toast.LENGTH_LONG).show();
                } else {

                    for (Usuario p : bd.listaUsuario())
                        if (p.getPlaca().equals(cadastraNome.getText().toString())) {
                            Toast.makeText(this, "Já existe uma pessoa com este nome.", Toast.LENGTH_LONG).show();
                            return;
                        }
                    Usuario usuario = new Usuario();
                        usuario.setNome(cadastraNome.getText().toString());
                        usuario.getPlaca();
                        bd.cadastraNomeUsuario(Usuario);

                }
            }



    public void Listar(View view) {
        Bundle sacolaObjetos = new Bundle();

        //sacolaObjetos.putSerializable("lista_pessoas",listaPessoa);

        Intent intent = new Intent(this,MostraUsuario.class);
        intent.putExtras(sacolaObjetos);
        startActivity(intent);

    }
}