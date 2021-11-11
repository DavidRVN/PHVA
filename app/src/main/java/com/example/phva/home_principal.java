package com.example.phva;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class home_principal extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragment_inicio, fragment_admin, fragment_employee, frament_p_be, fragment_p_cocola, fragment_p_copasst, fragment_supervisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_principal);
        fragment_inicio = new inicio();
        fragment_admin = new admin();
        fragment_employee = new employee();
        frament_p_be = new p_be();
        fragment_p_cocola = new p_cocola();
        fragment_p_copasst = new p_copasst();
        fragment_supervisor = new supervisor();
        getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_inicio).commit();
        loadData();
    }


    private void loadData() {
        transaction = getSupportFragmentManager().beginTransaction();

        SharedPreferences preferences = getSharedPreferences("which", MODE_PRIVATE);
        int forCase = preferences.getInt("case", 0);
        boolean isChecked = preferences.getBoolean("ischeck", false);
        switch (forCase) {
            case 0:
                if (isChecked)
                    transaction.replace(R.id.content_Fragment, fragment_admin);
                transaction.addToBackStack(null);
                  //  getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_admin).commit();
                Toast.makeText(home_principal.this, "Registrado como administrador", Toast.LENGTH_LONG).show();
                break;
            case 1:
                if (isChecked)
                    Toast.makeText(home_principal.this, "Clicked on android", Toast.LENGTH_LONG).show();
               // getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_employee).commit();
                transaction.replace(R.id.content_Fragment, fragment_employee);
                transaction.addToBackStack(null);
                break;
            case 2:
                if (isChecked)
                    transaction.replace(R.id.content_Fragment, fragment_supervisor);
                transaction.addToBackStack(null);
                   // getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_supervisor).commit();
                    Toast.makeText(home_principal.this, "Clicked on Data Structures", Toast.LENGTH_LONG).show();
                break;
            case 3:
                if (isChecked)
                    transaction.replace(R.id.content_Fragment, fragment_p_cocola);
                transaction.addToBackStack(null);
                   // getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_p_cocola).commit();
                    Toast.makeText(home_principal.this, "Clicked on HTML", Toast.LENGTH_LONG).show();
                break;
            case 4:
                if (isChecked)
                    transaction.replace(R.id.content_Fragment, frament_p_be);
                         transaction.addToBackStack(null);
                    //getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, frament_p_be).commit();
                    Toast.makeText(home_principal.this, "Clicked on CSS", Toast.LENGTH_LONG).show();
                    break;
            case 5:
                if (isChecked)
                    transaction.replace(R.id.content_Fragment, fragment_p_copasst);
                transaction.addToBackStack(null);
                   // getSupportFragmentManager().beginTransaction().add(R.id.content_Fragment, fragment_p_copasst).commit();
                    Toast.makeText(home_principal.this, "Clicked on CSS", Toast.LENGTH_LONG).show();
                break;
        }
        transaction.commit();
    }
}