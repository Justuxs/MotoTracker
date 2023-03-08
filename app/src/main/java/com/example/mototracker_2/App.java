package com.example.mototracker_2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.mototracker_2.Sql.Doa.PersonDoa;
import com.example.mototracker_2.Sql.Repo.PersonRepo;
import com.example.mototracker_2.models.Person;

public class App extends Application {

    public Person currentUser;
    private static Context context;
    public static PersonRepo personRepo;

    @Override
    public void onCreate() {
        System.out.println("Susikuriau");
        super.onCreate();
        context = getApplicationContext();
        personRepo= new PersonRepo(new PersonDoa(context));

        startService(new Intent(this, ReportService.class));
    }

}
