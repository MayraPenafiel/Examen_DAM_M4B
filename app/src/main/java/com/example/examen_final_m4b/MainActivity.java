package com.example.examen_final_m4b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animacion1= AnimationUtils.loadAnimation( this,R.anim.desplazamiento_arriba);
        ImageView logo_galeria= findViewById(R.id.iconss);
        logo_galeria.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,crudUsuario.class);
                startActivity(intent);
                finish();

            }
        }, 3000);
    }

}