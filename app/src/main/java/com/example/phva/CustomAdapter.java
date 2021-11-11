package com.example.phva;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<Note> allNotes;
    private DatabaseHelper databaseHelper;
    public String urlN;

    FragmentTransaction transaction;
    Fragment fragment_details;

    public CustomAdapter(Context context, List<Note> allNotes) {
        this.context = context;
        this.allNotes = allNotes;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_custom_layout, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(allNotes.get(position).getTitle());
        holder.date.setText(allNotes.get(position).getDate());
        holder.url.setText(allNotes.get(position).geturl());
        urlN = allNotes.get(position).geturl();


        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                TextView algo = view.findViewById(R.id.url);

                Toast.makeText(context, algo.getText(), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Select Action");

                builder.setPositiveButton(R.string.detalis_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(context, urlN, Toast.LENGTH_SHORT).show();


                        //
                        // customDialog(position);

                    }
                });

               /* builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        customDialog(position);

                    }
                });*/

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int status = databaseHelper.deleteData(allNotes.get(position).getId());
                        if (status == 1) {
                            allNotes.remove(allNotes.get(position));
                            notifyDataSetChanged();
                        } else {

                        }

                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, date, url;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.url);
            title = itemView.findViewById(R.id.custom_title);
            date = itemView.findViewById(R.id.custom_date);
            layout = itemView.findViewById(R.id.layout);

        }

    }


    private void customDialog(final int position) {

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_custom_dialog, null);
        builder.setView(view);

        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();

        final EditText title = view.findViewById(R.id.title);
        final EditText description = view.findViewById(R.id.description);
        final EditText urls = view.findViewById(R.id.url);
        final EditText Status = view.findViewById(R.id.status);
        final EditText Tp_doc = view.findViewById(R.id.tp_doc);
        final EditText Rol = view.findViewById(R.id.rol);

        title.setText(allNotes.get(position).getTitle());
        description.setText(allNotes.get(position).getDescription());
        urls.setText(allNotes.get(position).geturl());
        Status.setText(allNotes.get(position).getStatus());
        Tp_doc.setText(allNotes.get(position).getstp_doc());
        Rol.setText(allNotes.get(position).getRol());

        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titleValue = title.getText().toString();
                String descriptionValue = description.getText().toString();
                String url = urls.getText().toString();
                String statuss = Status.getText().toString();
                String tp_doc = Tp_doc.getText().toString();
                String rol = Rol.getText().toString();
                urlN = url;

                if (titleValue.isEmpty()) {
                    title.setError("Enter Title");
                    return;
                } else if (descriptionValue.isEmpty()) {
                    description.setError("Enter description");
                    return;
                }

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String date = format.format(calendar.getTimeInMillis());


                long status = databaseHelper.updateData(new Note(allNotes.get(position).getId(), titleValue, descriptionValue, date, url, statuss, tp_doc, rol));
                if (status == 1) {
                    alertDialog.dismiss();
                    allNotes.clear();
                    allNotes.addAll(databaseHelper.getAllNotes());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
                } else {
                    alertDialog.dismiss();
                    Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();

                }
            }
        });
        alertDialog.show();
    }
}
