package com.example.phva;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                TextView txt_recovery = findViewById(R.id.msg_register);
        TextView txt_register = findViewById(R.id.register_text);
        txt_recovery.setOnClickListener(v -> {
            Toast.makeText(this, "Clicked on HTML", Toast.LENGTH_LONG).show();
        });

        txt_register.setOnClickListener(v -> {
            showRegister();
        });

    }

    private void showRegister() {
        Intent register = new Intent(this, register.class);
        startActivity(register);
    }
}