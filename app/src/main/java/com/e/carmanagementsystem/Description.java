package com.e.carmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Description extends AppCompatActivity {

    //initialization of fields
    EditText GameName,NoOfPlayerRequired,EquipmentRequired,TeamA,TeamB,Rules,Description;
    Button Submit,Show;
    DatabaseHelper mydb;     //initialization of Sqlite database helper class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        // casting of all fiels
        GameName=(EditText)findViewById(R.id.etGameName);
        NoOfPlayerRequired=(EditText)findViewById(R.id.etPlayerRequired);
        EquipmentRequired=(EditText)findViewById(R.id.etEquipment);
        TeamA=(EditText)findViewById(R.id.Team_A_Name);
        TeamB=(EditText)findViewById(R.id.Team_B_Name);
        Rules=(EditText)findViewById(R.id.etRules);
        Description=(EditText)findViewById(R.id.etDescription);
        mydb=new DatabaseHelper(this);                   //creating of new databasehelper class
        Show=(Button)findViewById(R.id.btn_show);
        Submit=(Button)findViewById(R.id.btnSubmit);

        // listening of submit button
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Checking field of Description
                // if all the fields are fill then show alertbox

                if (TextUtils.isEmpty(GameName.getText().toString()) || TextUtils.isEmpty(NoOfPlayerRequired.getText().toString()) ||
                        TextUtils.isEmpty(EquipmentRequired.getText().toString()) || TextUtils.isEmpty(TeamA.getText().toString())
                        || TextUtils.isEmpty(TeamB.getText().toString()) || TextUtils.isEmpty(Rules.getText().toString()) ||
                        TextUtils.isEmpty(Description.getText().toString())) {
                    alertbox();
                } else {
                    // inserting data into database
                    boolean isInserted = mydb.insertData(GameName.getText().toString(),
                                                NoOfPlayerRequired.getText().toString(),
                                                EquipmentRequired.getText().toString(),
                                                TeamA.getText().toString(),
                                                TeamB.getText().toString(),
                                                Rules.getText().toString(),
                                                Description.getText().toString());

                // checking the data is properly inserted or not and then show the message related to that.
                if (isInserted)
                    Toast.makeText(Description.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Description.this, "NotInserted", Toast.LENGTH_SHORT).show();
            }
            }
        });

        // Moving from Description activity to list_show activity
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Description.this,List_Show.class);
                startActivity(intent);
            }
        });
    }

    // AlertBox
    public void alertbox()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("ALERT");
        builder.setMessage("Please fill all details");
        builder.show();
    }
}
