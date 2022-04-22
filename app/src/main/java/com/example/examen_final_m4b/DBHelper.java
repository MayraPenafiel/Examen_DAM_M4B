package com.example.examen_final_m4b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "SuperMercado.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Usuarios(id TEXT primary key, nombreCorto TEXT, password TEXT, permisos TEXT, foto Byte)"); }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {DB.execSQL("drop Table Uuarios");}

    public Boolean crear(String id,String nombre,String password,String permisos,Byte imagen){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("nombreCorto", nombre);
        contentValues.put("password",password);
        contentValues.put("permisos",permisos);
        contentValues.put("foto",imagen);
        long result=DB.insert("Usuarios", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean actualizar(String id,String nombre,String password,String permisos,Byte imagen)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("password", password);
        contentValues.put("permisos",permisos);
        contentValues.put("foto",imagen);
        Cursor cursor = DB.rawQuery("Select * from Usuarios where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.update("Usuarios", contentValues, "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean eliminar(String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usuarios where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Usuarios", "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor listar()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usuarios", null);
        return cursor;
    }
}
