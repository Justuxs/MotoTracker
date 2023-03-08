package com.example.mototracker_2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mototracker_2.App;
import com.example.mototracker_2.R;
import com.example.mototracker_2.activities.LoginActivity;
import com.example.mototracker_2.models.Person;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void onSignClick(View view){
        EditText editText = findViewById(R.id.emailET_main);
        String email = editText.getText().toString();
        editText = findViewById(R.id.passwordET_main);
        String password = editText.getText().toString();

        Person person= App.personRepo.getPerson(email,password);
        if(person != null){
            System.out.println("Sign up ok");
            System.out.println(person.toString());
            Toast.makeText(this, "OK",Toast.LENGTH_SHORT);
        }
        else{
            System.out.println("Sign up bad");

            Toast.makeText(this, "Bad email or password",Toast.LENGTH_SHORT);
        }
    }
}