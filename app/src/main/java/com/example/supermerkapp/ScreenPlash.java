package com.example.supermerkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenPlash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Pantalla completa
        setContentView(R.layout.activity_screen_plash);
        //animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        ImageView imgTitle = findViewById(R.id.imgTitle);
        TextView tvVersion = findViewById(R.id.tvVersion);
        ImageView imgLogoMerk = findViewById(R.id.imgLogoMerk);



       imgTitle.setAnimation(animacion2);
        tvVersion.setAnimation(animacion2);
        imgLogoMerk.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // Intent intent = new Intent(ScreenPlash.this, boarding_screen.class);
                startActivity(new Intent(getApplicationContext(),boarding_screen.class));
                finish();
            }
        }, 4000);
    }
}