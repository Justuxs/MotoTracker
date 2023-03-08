package com.example.mototracker_2.Sql.Doa;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mototracker_2.Sql.helper.Colum;
import com.example.mototracker_2.Sql.helper.DBHelper;
import com.example.mototracker_2.Sql.helper.Saveable;
import com.example.mototracker_2.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDoa extends DBHelper implements Saveable<Person> {

    private String table = "person";
    private Colum colum1= new Colum("ID", Colum.Type.TEXT,true);
    private Colum colum2= new Colum("name", Colum.Type.TEXT,false);
    private Colum colum3= new Colum("password", Colum.Type.TEXT,false);
    private Colum colum4= new Colum("email", Colum.Type.TEXT,false);
    private Colum colum5= new Colum("phone", Colum.Type.TEXT,false);
    private List<Colum> colums = Arrays.asList(colum1,colum2,colum3,colum4,colum5);

    public PersonDoa(Context context) {
        super(context.getApplicationContext(),"person");
        super.setCOLUMNS(colums);
    }

    @Override
    public boolean addRecord(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(colum1.getName(), person.getId());
        values.put(colum2.getName(), person.getName());
        values.put(colum3.getName(), person.getPassword());
        values.put(colum4.getName(), person.getEmail());
        values.put(colum5.getName(), person.getPhoneNumber());
        System.out.println("Ikeliu ");
        long suc=db.insert(table, null, values);
        db.close();

        return suc == -1 ? false : true;
    }

    @Override
    public List<Person> getAllRecords() {

        List<Person> records = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + table;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String pass = cursor.getString(2);
                String email = cursor.getString(3);
                String phone = cursor.getString(4);
                Person person = new Person(id,email,pass,name,phone);
                records.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return records;
    }

    @Override
    public void updateRecord(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(colum2.getName(), person.getName());
        values.put(colum3.getName(), person.getPassword());
        values.put(colum4.getName(), person.getEmail());
        values.put(colum5.getName(), person.getPhoneNumber());

        // Update the record with the given ID
        db.update(table, values, colum1.getName() + " = ?", new String[] { String.valueOf(person.getId()) });

        db.close();
    }

    @Override
    public void deleteRecord(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the record with the given ID
        db.delete(table, colum1.getName() + " = ?", new String[] { String.valueOf(person.getId()) });

        db.close();
    }

    public Person getRecord(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table,  null,
                colum4.getName()+" = ? AND "+colum3.getName()+" = ?", new String[]{email, password},
                null, null, null);


        if (cursor != null && cursor.moveToFirst()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(4);
            return new Person(id,email,password,name,phone);
        }
        else return null;
    }

    public boolean propExist(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(table, new String[]{colum4.getName()}, colum4.getName()+" = ?", new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        else return false;
    }
}
