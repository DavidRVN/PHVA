package com.example.phva;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    Button text;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        text = findViewById(R.id.click);
       text.setOnClickListener(v -> showAlertDialog());
    }


    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(register.this);
        alertDialog.setTitle("Seleccione su perfil");
        String[] items = {"Administrador", "Empleado", "Supervisor", "Presidente COCOLA", "Presidente BE", "Presidente COPASST"};
        boolean[] checkedItems = {false, false, false, false, false, false};
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                SharedPreferences preferences = getSharedPreferences("which", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("ischeck", isChecked);
                editor.putInt("case", which);
                editor.commit();
                ShowAdmin();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    private void ShowAdmin() {
        Intent admin = new Intent(this, home_principal.class);
        startActivity(admin);
    }
}



