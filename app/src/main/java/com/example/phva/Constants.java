package com.example.phva;

public class Constants {

    public static final String DATABASE_NAME = "sst1.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "employees";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_ROL = "rol";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_STATUS_DOC = "status_doc";
    public static final String COLUMN_TP_DOC = "tp_doc";


    public static String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT, "
            + COLUMN_DATE + " TEXT, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_ROL + " TEXT, "
            + COLUMN_STATUS_DOC + " TEXT, "
            + COLUMN_URL +  " TEXT, "
            + COLUMN_TP_DOC + " TEXT "
            + ")";
}
