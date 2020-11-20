package com.example.aps_g2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends SQLiteOpenHelper {
    private static String NOME_BANCO ="exercicio";
    private static int VERSION = 2;
    public UsuarioDao(Context context) {

        super(context, NOME_BANCO, null, VERSION);
    }
    public void cadastraNomeUsuario(String texto){
        ContentValues valores = new ContentValues();
        valores.put("colunaA",texto);
        getWritableDatabase().insert("nome",null, valores);
        Log.i("exercicio", "adicionaTexto");
    }

    public List<String> listaUsuario(){
        ArrayList<String> lista = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor tabela = db.rawQuery("select * from nome",null);
        tabela.moveToFirst();
        for(int i=0; i < tabela.getCount(); i++){
            String valor = tabela.getString(0);
            lista.add(valor);
            tabela.moveToNext();
        }

        tabela.close();
        return lista;
    }
    public void salvarUsuario(Usuario usuario){
    String sql = "insert into usuario (nome,placa) value ('" + usuario.getNome() + "' , '" + usuario.getPlaca() + "' )";
        Log.i("exercicio","SQL para inserir na tabela usuario: " + sql);
        getWritableDatabase().execSQL(sql);
        Log.i("exercicio", "usuario salvo com sucesso no banco de dados");
    }


    public UsuarioDao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
