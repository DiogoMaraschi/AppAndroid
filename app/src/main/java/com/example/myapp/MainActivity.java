package com.example.myapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    EditText edMin;
    EditText edMax;


    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();

                String strMin = edMin.getText().toString();
                String strMax = edMax.getText().toString();

                if (strMin.isEmpty()){
                    edMin.setError("Informe um número");
                    edMin.requestFocus();
                    return;
                }

                if (strMax.isEmpty()){
                    edMax.setError("Informe um número");
                    edMin.requestFocus();
                    return;
                }

                int min = Integer.parseInt(strMin);
                int max = Integer.parseInt(strMax);



                i = r.nextInt(max - min) + min;
                button.setText(Integer.toString(i));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("cicloVida", "OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("cicloVida", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("cicloVida", "OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("cicloVida", "OnPause");
        Toast.makeText(this, "onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("cicloVida", "OnStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("cicloVida", "OnResume");
    }
}