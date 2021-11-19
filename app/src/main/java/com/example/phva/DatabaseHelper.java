package com.example.phva;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Constants.CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public long insertData(Note note) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COLUMN_DATE, note.getDate());
        contentValues.put(Constants.COLUMN_TITLE, note.getTitle());
        contentValues.put(Constants.COLUMN_DESCRIPTION, note.getDescription());
        contentValues.put(Constants.COLUMN_ROL, note.getRol());
        contentValues.put(Constants.COLUMN_STATUS_DOC, note.getStatus());
        contentValues.put(Constants.COLUMN_URL, note.geturl());
        contentValues.put(Constants.COLUMN_TP_DOC, note.getstp_doc());

        return sqLiteDatabase.insert(Constants.TABLE_NAME, null, contentValues);

    }

    public List<Note> getAllNotes() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<Note> dataList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Constants.TABLE_NAME, null);
        if (cursor.moveToFirst()) {


            do {
                Note note;
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String description = cursor.getString(3);
                String date = cursor.getString(2);
                String url = cursor.getString(6);
                String status = cursor.getString(5);
                String tp_doc = cursor.getString(7);
                String rol = cursor.getString(4);

                note = new Note(id, title, description, date, url, status, tp_doc, rol);
                dataList.add(note);
            } while (cursor.moveToNext());
        }
        return dataList;
    }


    public int updateData(Note note) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COLUMN_DATE, note.getDate());
        contentValues.put(Constants.COLUMN_TITLE, note.getTitle());
        contentValues.put(Constants.COLUMN_DESCRIPTION, note.getDescription());

        int status = sqLiteDatabase.update(Constants.TABLE_NAME, contentValues, "id=?", new String[]{String.valueOf(note.getId())});
        return status;
    }

    public int deleteData(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int status = sqLiteDatabase.delete(Constants.TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
        return status;
    }
}
