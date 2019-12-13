package com.e.carmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    // Initialization of all fields
    EditText username,password;
    TextView forgetPassword,create_new_account;
    Button login,Phone_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Casting of all fields with their id 's
        username=(EditText)findViewById(R.id.login_email);
        password=(EditText)findViewById(R.id.login_password);
        login=(Button)findViewById(R.id.login_button);
        forgetPassword=(TextView)findViewById(R.id.forget_password_link);
        create_new_account=(TextView)findViewById(R.id.need_new_account_link);
        Phone_sign_up=(Button)findViewById(R.id.phone_login_button);

        // Setting of background texture with specfic time interval using animation
        // Initialization and then casting the layout of a particular activity
        RelativeLayout relativeLayout=findViewById(R.id.login);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);                                          //Fade in 4000 millseconds
        animationDrawable.setExitFadeDuration(2000);                                          //Fade out after 2000 millisecond
        animationDrawable.start();

        // Listening the log in button and authenticate the user
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") || password.getText().toString().equals("123"))  //Checking the username and password
                {
                    Intent intent =new Intent(LoginActivity.this,Description.class);     // moving from Login activity to Description activity
                    startActivity(intent);
                }
            }
        });

        // Listener of forget password button
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);   //Creating Alert dialog for some message
                builder.setTitle("ALERT");
                builder.setMessage("Sorry\n UNDER CONSTRUCTION");
                builder.show();
            }
        });

        // listener of create new account button
        create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);   //Creating Alert dialog for some message
                builder.setTitle("ALERT");
                builder.setMessage("Sorry\n UNDER CONSTRUCTION");
                builder.show();
            }
        });

        // listener of phone sign up button
        Phone_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);    //Creating Alert dialog for some message
                builder.setTitle("ALERT");
                builder.setMessage("Sorry\n UNDER CONSTRUCTION");
                builder.show();
            }
        });

    }
}
