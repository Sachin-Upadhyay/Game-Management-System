package com.e.carmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="GameManagementSystem.db";  //database name
    public static final String TABLE_NAME="Database_Table";              //table name

    // initialize all the fields
    public static final String COL_1="ID";
    public static final String COL_2="GameName";
    public static final String COL_3="PlayerRequired";
    public static final String COL_4="Equipments";
    public static final String COL_5="TeamA";
    public static final String COL_6="TeamB";
    public static final String COL_7="Rule";
    public static final String COL_8="Description";

    //constructor
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating a table with all fields
        db.execSQL("Create Table " +TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,GameName TEXT,PlayerRequired TEXT,Equipments TEXT,TeamA TEXT,TeamB TEXT,Rule TEXT,Description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //Data insertion method
    public boolean insertData(String gameName,String PlayerRequired,String Equipments,String TeamA,String TeamB , String Rule,String Description) {
        // Openining database to write in the database
        SQLiteDatabase db = this.getWritableDatabase();
        // Gettting current fields of the database
        ContentValues contentValues = new ContentValues();
        // Setting the data to the specified fields of the database
        contentValues.put(COL_2, gameName);
        contentValues.put(COL_3, PlayerRequired);
        contentValues.put(COL_4, Equipments);
        contentValues.put(COL_5, TeamA);
        contentValues.put(COL_6, TeamB);
        contentValues.put(COL_7, Rule);
        contentValues.put(COL_8, Description);

        //Inserting data in database it will return -1 if the data is not inserted into database properly
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    // Getting data from the database
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getReadableDatabase();  // Opeining database for reading data
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null); // Fetching All data from the given table name

        //Returning the database data
        return res;

    }
}