package com.example.persistencialogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contato.db";
    private static final String TABLE_NAME="contato";
    private static final String COL_NAME="nome";
    private static final String COL_EMAIL="email";
    private static final String COL_USUARIO="usuario";
    private static final String COL_PAS="senha";
    private static final String TABLE_CREATE="create table " + TABLE_NAME +
            "("+COL_NAME + " text not null, " + COL_EMAIL + " text not null, " +
            COL_USUARIO + " text not null, " + COL_PAS + " text not null);";
    private SQLiteDatabase db;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
    }

    public void insereContato(Contato c){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, c.getNome());
        values.put(COL_EMAIL, c.getEmail());
        values.put(COL_USUARIO, c.getUsuario());
        values.put(COL_PAS, c.getSenha());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String buscarSenha(String usuario){
        db=this.getReadableDatabase();
        String query="select usuario, senha from " + TABLE_NAME;
        String a, b;
        b="não encontrado";
        Cursor cursor=db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if (a.equals(usuario)){
                    b=cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;
    }

}
