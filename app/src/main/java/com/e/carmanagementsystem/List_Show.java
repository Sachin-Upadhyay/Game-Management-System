package com.e.carmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List_Show extends AppCompatActivity {

    // Initialization of fields
    DatabaseHelper myDb;   //creating of new database reference
    List<Getter> heroList;  // creating a list object with getter class as a passing argument

    ListView listView;       //creating a list view object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__show);

        heroList = new ArrayList<>();                          // creating a array list of list class
        myDb=new DatabaseHelper(this);                  //creating a new databasw helper object
        listView = (ListView) findViewById(R.id.list_View);     //casting of list view
        getData();
    }
    private void getData(){

        // Call getAllData function from database helper class and put the data inside a cursor object
        Cursor res=myDb.getAllData();
        if (res.getCount()==0)             //checking the count of the data if it is empty the return the value
        {
            return;
        }

        // loop through all the data of given res
        while(res.moveToNext())
        {
            //adding the new data to herolist
            heroList.add(new Getter(res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7) ));

            //setting the herolist data according to the given listview one the list adapter
            List_Adapter adapter = new List_Adapter(List_Show.this, R.layout.list_adapter, heroList);

            //attaching adapter to the listview to the interface
            listView.setAdapter(adapter);
        }
    }
}