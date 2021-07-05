package com.example.unittwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText etlogin;
    private EditText etpasword;
    private Button mbtnlogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etlogin=findViewById(R.id.etname1);
        etpasword=findViewById(R.id.etpassw);
        mbtnlogin2=findViewById(R.id.btnsignip);
        mbtnlogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isnaam=isnamevalid1();
                boolean ispasswrd=ispasswordvalid1();
                if(isnaam && ispasswrd){
                    Intent inten=new Intent(LoginActivity.this,HomeActivity.class);
                    inten.putExtra("naam",etlogin.getText().toString());
                    startActivity(inten);
                }

            }
        });
    }
    private boolean ispasswordvalid1(){
        if(etpasword.getText().toString().length()>=6){
            return true;
        }else{
            etpasword.setError("Password length is small");
            return false;
        }
    }

    private boolean isnamevalid1(){
        if(etlogin.getText().toString().length()>=4){
            return true;
        }else{
            etlogin.setError("Invalid name");
            return false;
        }
    }
}