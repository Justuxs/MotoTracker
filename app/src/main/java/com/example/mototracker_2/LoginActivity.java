package com.example.mototracker_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mototracker_2.fuctions.Validator;
import com.example.mototracker_2.models.Person;
import com.example.mototracker_2.models.User;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginas);
    }

    public void onRegisterClick(View view){
        System.out.println("onRegisterClick");
        EditText editText = findViewById(R.id.nameET);
        String name = editText.getText().toString();
        editText = findViewById(R.id.passwordET);
        String password = editText.getText().toString();
        editText = findViewById(R.id.emailET);
        String email = editText.getText().toString();
        editText = findViewById(R.id.phoneET);
        String phone = editText.getText().toString();

        Boolean isGood= false;

        if(!Validator.NonEmptyText(password)){
            this.setTextInputHelper(findViewById(R.id.passwordInputLayout), "*Required.");
        }
        else if(!Validator.TextLength(password,8,20)) {
            this.setTextInputHelper(findViewById(R.id.passwordInputLayout), "Must contains at least 8 characters and at most 20 characters.");
        } else if(!Validator.Password(password))this.setTextInputHelper(findViewById(R.id.passwordInputLayout), "It contains at least one digit.\n" +
                "Must contains at least one upper case alphabet.\n" +
                "Must contains at least one lower case alphabet. ");
        else{
            this.setTextInputHelper(findViewById(R.id.passwordInputLayout), "");
            isGood= true;
        }

        if(!Validator.NonEmptyText(name)){
            this.setTextInputHelper(findViewById(R.id.nameInputLayout), "*Required.");
            isGood= false;
        }
        else{
            this.setTextInputHelper(findViewById(R.id.nameInputLayout), "");
        }

        if(!Validator.Phone(phone)) {
            isGood= false;
            this.setTextInputHelper(findViewById(R.id.phoneInputLayout), "Bad phone number.");
        } else{
            this.setTextInputHelper(findViewById(R.id.phoneInputLayout), "");
        }

        if(!Validator.Email(email)) {
            isGood= false;
            this.setTextInputHelper(findViewById(R.id.emailInputLayout), "Bad email adress.");
        } else{
            this.setTextInputHelper(findViewById(R.id.emailInputLayout), "");
        }
        if(isGood)Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Please properly fill form", Toast.LENGTH_SHORT).show();

    }

    private void setTextInputHelper(TextInputLayout editText, String message) {
        editText.setHelperText(message);
    }


}