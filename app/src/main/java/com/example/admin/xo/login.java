package com.example.admin.xo;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextInputLayout emailLayout;
    TextInputLayout passwordLayout;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailLayout = findViewById(R.id.emailLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailLayout.getEditText().getText().toString().equals("")){
                    emailLayout.getEditText().setError("Email cannot be empty!");
                }
                if(passwordLayout.getEditText().getText().toString().equals("")){
                    passwordLayout.getEditText().setError("Password cannot be empty!");
                }
                else if (emailLayout.getEditText().getText().toString().equals("gulus")
                        &&passwordLayout.getEditText().getText().toString().equals("gulus")
                        ){
                   Intent toy = new Intent(login.this,kisiEkleme.class);
                   startActivity(toy);
                }
                else{
                    Toast.makeText(login.this,"başarısız ",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
