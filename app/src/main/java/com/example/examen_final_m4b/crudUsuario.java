package com.example.examen_final_m4b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class crudUsuario extends AppCompatActivity {
    EditText id, nombre, password;
    Switch admin,cajero,cliente;
    Button crear, modificar, eliminar, listar;
    ImageView foto;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuario);
        id = findViewById(R.id.etxtid);
        nombre=findViewById(R.id.etxtnomcort);
        password= findViewById(R.id.etxtpassword);
        admin =findViewById(R.id.swadmin);
        cajero = findViewById(R.id.swcajero);
        cliente = findViewById(R.id.swcliente);
        crear = findViewById(R.id.btcrear);
        modificar= findViewById(R.id.btnmodificar);
        eliminar=findViewById(R.id.btneliminar);
        listar = findViewById(R.id.btnlistar);
        DB = new DBHelper(this);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtId = id.getText().toString();
                String txtNombreCorto = nombre.getText().toString();
                String txtPassword = password.getText().toString();
                String txtrol="nada";
                if (admin.isClickable()) {
                    txtrol = "Adminstrador";
                }
                if (cajero.isClickable()) {

                    txtrol = "Cajero";
                }
                if (cliente.isClickable()) {

                    txtrol = "Cliente";
                }
                String rol=txtrol;
                Byte foto = null;
                Boolean validarexistencia = DB.crear(txtId, txtNombreCorto, txtPassword, txtrol, foto);
                if (validarexistencia == true) {
                    Toast.makeText(crudUsuario.this, "Usuario Creado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(crudUsuario.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtId = id.getText().toString();
                String txtNombreCorto = nombre.getText().toString();
                String txtPassword = password.getText().toString();
                String txtrol = "";
                if (admin.isClickable()) {

                    txtrol = "Adminstrador";
                }
                if (cajero.isClickable()) {

                    txtrol = "Cajero";
                }
                if (cliente.isClickable()) {

                    txtrol = "Cliente";
                }
                Byte foto = null;
                Boolean validarmodificarion = DB.actualizar(txtId, txtNombreCorto, txtPassword, txtrol, foto);
                if (validarmodificarion == true) {
                    Toast.makeText(crudUsuario.this, "Usuario Actualizado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(crudUsuario.this, "Usuario no Actualizado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtId = id.getText().toString();
                Boolean validareliminacion = DB.eliminar(txtId);
                if(validareliminacion==true) {
                    Toast.makeText(crudUsuario.this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(crudUsuario.this, "Usuario no Eliminado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.listar();
                if(res.getCount()==0){
                    Toast.makeText(crudUsuario.this, "No existe Usuario", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Identificacion:"+res.getString(0)+"\n");
                    buffer.append("Nombre:"+res.getString(1)+"\n");
                    buffer.append("Rol: "+res.getString(3)+"\n");
                    buffer.append("Foto: "+res.getString(4)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(crudUsuario.this);
                builder.setCancelable(true);
                builder.setTitle("Informacion De Usuarios");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}