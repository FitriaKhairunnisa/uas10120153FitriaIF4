package com.example.uas10120153fitriaif4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register10120153 extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register10120153);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://uas10120153fitriaif4-default-rtdb.firebaseio.com/");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {

                String Username = etUsername.getText().toString();
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();

                if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                }else{
                    database = FirebaseDatabase.getInstance().getReference("Users");
                    database.child(Username).child("Username").setValue(Username);
                    database.child(Username).child("Email").setValue(Email);
                    database.child(Username).child("Password").setValue(Password);

                    Toast.makeText(getApplicationContext(), "Register Berhasil!!", Toast.LENGTH_SHORT).show();
                    Intent Register = new Intent(getApplicationContext(), Login10120153.class);
                    startActivity(Register);

                }

            }
        });
    }
}