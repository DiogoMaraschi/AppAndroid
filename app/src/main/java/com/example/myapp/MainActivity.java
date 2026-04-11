package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;

    TextView textView;

    EditText edPeso, edAltura;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);

        textView = findViewById(R.id.textView);
        btnCalcular = findViewById(R.id.buttonCalcular);
        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);
        imageView = findViewById(R.id.imageView);

        btnCalcular.setOnClickListener(v -> {
            String strAltura = edAltura.getText().toString();
            String strPeso = edPeso.getText().toString();

            if (strAltura.isEmpty()){
                edAltura.setError("Informe a altura");
                edAltura.requestFocus();
                return;
            }

            if (strPeso.isEmpty()){
                edPeso.setError("Informe o peso");
                edPeso.requestFocus();
                return;
            }

            double peso = Double.parseDouble(strPeso);
            double altura = Double.parseDouble(strAltura);

            double imc = peso/(altura*altura);

            DecimalFormat dc  = new DecimalFormat("##.##");
            textView.setText(dc.format(imc));

            if (imc < 18.5) {
                imageView.setImageResource(R.drawable.abaixopeso);
                return;
            }
            if (imc < 25) {
                imageView.setImageResource(R.drawable.normal);
                return;
            }
            if (imc < 30) {
                imageView.setImageResource(R.drawable.sobrepeso);
                return;
            }
            if (imc < 35) {
                imageView.setImageResource(R.drawable.obesidade1);
                return;
            }
            if (imc < 40) {
                imageView.setImageResource(R.drawable.obesidade2);
                return;
            }

            imageView.setImageResource(R.drawable.obesidade3);
            
        });



    }
}