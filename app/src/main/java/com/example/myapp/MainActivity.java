package com.example.myapp;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnProximo, btnAnterior;

    ImageView imageView;

    int fotos[] = new int[]{R.drawable.cachorro,R.drawable.gardem, R.drawable.happy, R.drawable.patinho, R.drawable.porquinho,};

    int posicao=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);

        btnAnterior = findViewById(R.id.buttonAnterior);
        btnProximo = findViewById(R.id.buttonProximo);

        imageView = findViewById(R.id.imageView);

        btnProximo.setOnClickListener(v -> {
            posicao++;

            if (posicao>fotos.length-1) {
                posicao = 0;
            }
            imageView.setImageResource(fotos[posicao]);
            Toast.makeText(this, String.valueOf(posicao), Toast.LENGTH_SHORT).show();
        });

        btnAnterior.setOnClickListener(v -> {
            posicao--;

            if (posicao<0) {
                posicao = fotos.length-1;
            }
            imageView.setImageResource(fotos[posicao]);
            Toast.makeText(this, String.valueOf(posicao), Toast.LENGTH_SHORT).show();
        });

    }
}