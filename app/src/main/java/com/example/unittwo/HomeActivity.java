package com.example.unittwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvname1=findViewById(R.id.tvhomename);
        Intent intent=getIntent();
        String useremail=intent.getStringExtra("naam");
        String username=intent.getStringExtra("usename");
        tvname1.setText(useremail);
        tvname1.setText(username);

    }
}