package com.example.aps_g2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MostraUsuario extends AppCompatActivity {
    private List<String> lista;
    private UsuarioDao bd = new UsuarioDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_usuario);
        ListView listaUsusario =(ListView)findViewById(R.id.listar);
        lista = bd.listaUsuario();


        ArrayAdapter<Usuario> listaAdapter =
                new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,lista);

        listaUsusario.setAdapter(listaAdapter);

        listaUsusario.setOnItemClickListener(new MeuItemEvento());
    }

    private class MeuItemEvento implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {

            Usuario usuarioSelecionado = lista.get(indice);
            Bundle sacola = new Bundle();
            sacola.putSerializable("usuario_Selecionado", usuarioSelecionado);

            Intent intent = new Intent(MostraUsuario.this,MostraUsuario.class);
            intent.putExtras(sacola);
            startActivity(intent);


            Log.i("exercicio", usuarioSelecionado.getNome());
            Log.i("exercicio",usuarioSelecionado.getPlaca());
        }
    }
    }
    }
}