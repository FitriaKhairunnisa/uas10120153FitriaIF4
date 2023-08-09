package com.example.uas10120153fitriaif4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login10120153 extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegister, btnLogin;

    private DatabaseReference database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login10120153);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(getApplicationContext(), Register10120153.class);
                startActivity(Register);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = etUsername.getText().toString();
                String Password = etPassword.getText().toString();

                database = FirebaseDatabase.getInstance().getReference("users");

                if (Username.isEmpty() || Password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
                }else{
                    database.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.child(Username).exists()) {
                                if (snapshot.child(Username).child("Password").getValue(String.class).equals(Password)){
                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                                    Intent masuk = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(masuk);
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Data Belum Terdaftar", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}