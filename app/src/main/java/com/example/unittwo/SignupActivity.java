package com.example.unittwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private EditText etname;
    private EditText etemail;
    private EditText etpassword;
    private Button mbtnsignup;
    private String validemail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        mbtnsignup=findViewById(R.id.btnsignup);
        mbtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isemail=isemailvalid();
                boolean isname=isnamevalid();
                boolean ispassword=ispasswordvalid();
                if(isemail && isname && ispassword){
                    Intent intent=new Intent(SignupActivity.this,HomeActivity.class);
                    intent.putExtra("usename",etname.getText().toString());
                    startActivity(intent);

                }


            }
        });
    }
    private boolean ispasswordvalid(){
        if(etpassword.getText().toString().length()>=6){
            return true;
        }else{
            etpassword.setError("Password length is small");
            return false;
        }
    }
    private boolean isemailvalid() {
        if (etemail.getText().toString().matches(validemail)) {
            return true;
        } else {
            etemail.setError("Invalid Email");
            return false;
        }
    }
    private boolean isnamevalid(){
        if(etname.getText().toString().length()>=4){
            return true;
        }else{
            etname.setError("Invalid name");
            return false;
        }
    }
}