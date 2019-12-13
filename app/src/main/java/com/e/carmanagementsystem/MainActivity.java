package com.e.carmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

// when the app start this function first call and execute its operation ,it refer the activity to login activity
    @Override
    protected void onStart() {
        super.onStart();
        sendToLogin();
    }

    private void sendToLogin()
    {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
