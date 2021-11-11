package com.example.phva;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class employee extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    DatabaseHelper databaseHelper;
    CustomAdapter adapter;
    List<Note> dataList;

    public employee() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        databaseHelper = new DatabaseHelper(getContext());
        dataList = new ArrayList<>();
        dataList = databaseHelper.getAllNotes();
        adapter = new CustomAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);

        addButton = rootView.findViewById(R.id.addButton);

        addButton.setOnClickListener(v -> {
            customDialog(inflater, container);
        });
        return rootView;
    }


    private void customDialog(LayoutInflater inflater, ViewGroup container) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        View view = getLayoutInflater().inflate(R.layout.activity_custom_dialog, null);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        final EditText title = view.findViewById(R.id.title);
        final EditText description = view.findViewById(R.id.description);
        final EditText urls = view.findViewById(R.id.url);
        final EditText Status = view.findViewById(R.id.status);
        final EditText Tp_doc = view.findViewById(R.id.tp_doc);
        final EditText Rol = view.findViewById(R.id.rol);

        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titleValue = title.getText().toString();
                String descriptionValue = description.getText().toString();
                String url = urls.getText().toString();
                String status_doc = Status.getText().toString();
                String tp_doc = Tp_doc.getText().toString();
                String rol = Rol.getText().toString();

                if (titleValue.isEmpty()) {
                    title.setError("Enter Title");
                    return;
                } else if (descriptionValue.isEmpty()) {
                    description.setError("Enter description");
                    return;
                }

                //https://www.enter.co
                Calendar calendar = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String date = format.format(calendar.getTimeInMillis());
                long status = databaseHelper.insertData(new Note(titleValue, descriptionValue, date, url, status_doc, tp_doc, rol));
                dataList = databaseHelper.getAllNotes();


                alertDialog.dismiss();
                if (status != -1) {
                    recyclerView.setAdapter(adapter);
                    adapter = new CustomAdapter(getContext(), dataList);
                    Toast.makeText(getContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed to Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }

    private void loadData() {

        /*View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);*/

        dataList = new ArrayList<>();
        dataList = databaseHelper.getAllNotes();

        if (dataList.size() > 0) {
            adapter = new CustomAdapter(getContext(), dataList);
            recyclerView.setAdapter(adapter);
            //  adapter.notifyDataSetChanged();
            Toast.makeText(getContext(), "Algo paso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}