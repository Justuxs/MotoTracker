package com.example.mototracker_2.Sql.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    // Database name and version
    private static final String DATABASE_NAME = "mydb";
    private static final int DATABASE_VERSION = 1;

    private String TABLE_NAME;
    private List<Colum> COLUMNS;


    // Constructor
    public DBHelper(Context context, String table_name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        TABLE_NAME=table_name;
    }

    public void setCOLUMNS(List<Colum> COLUMNS) {
        this.COLUMNS = COLUMNS;
    }

    // Called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {

        String colum_names=" ( ";
        for (Colum c: COLUMNS)colum_names+=c.toString()+", ";
        String newColums = colum_names.substring(0, colum_names.length() - 2);

        newColums+= ");";

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + newColums ;
        db.execSQL(CREATE_TABLE);
    }

    // Called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create a new table
        onCreate(db);
    }

    /*
    // Method to add a new record to the database
    public void addRecord(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);

        // Insert the new record into the table
        db.insert(TABLE_NAME, null, values);

        db.close();
    }*/
/*
    // Method to get all records from the database
    public List<MyModel> getAllRecords() {
        List<MyModel> records = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                MyModel model = new MyModel();
                model.setId(Integer.parseInt(cursor.getString(0)));
                model.setName(cursor.getString(1));
                model.setEmail(cursor.getString(2));

                records.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return records;
    }
*/
    /*
    // Method to update an existing record in the database
    public void updateRecord(MyModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, model.getName());
        values.put(COLUMN_EMAIL, model.getEmail());

        // Update the record with the given ID
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[] { String.valueOf(model.getId()) });

        db.close();
    }
*/

    /*
    // Method to delete a record from the database
    public void deleteRecord(MyModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the record with the given ID
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(model.getId()) });

        db.close();
    }*/
}
