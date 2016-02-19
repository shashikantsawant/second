package com.spoton.soliteapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by shashi on 1/12/16.
 */

 public class DatabaseHelper extends SQLiteOpenHelper  {

    String rolno;

 public static final String DatabaseName="spoton_student.db";

    public static final String CreateQuery="CREATE TABLE "+FormContents.NewFormDetail.Table_Name+"("+FormContents.NewFormDetail.Col_Roll+" Text PRIMARY KEY,"+FormContents.NewFormDetail.Col_Name+" Text,"
            +FormContents.NewFormDetail.Col_Add+" Text,"+FormContents.NewFormDetail.Col_Class+" Text,"+FormContents.NewFormDetail.Col_Mark+" Text);";

    public DatabaseHelper(Context context)
    {

          super(context, DatabaseName, null, 1);
    //     db.execSQL(CreateQuery);
          Log.e("DATABASE OPERATIONS","Database Create / Open Successfully");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CreateQuery);

        Log.e("DATABASE OPERATIONS","Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  void  adRecord(String rollno,String name,String address,String clas,String mark,SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(FormContents.NewFormDetail.Col_Roll,rollno);
        contentValues.put(FormContents.NewFormDetail.Col_Name,name);
        contentValues.put(FormContents.NewFormDetail.Col_Add,address);
        contentValues.put(FormContents.NewFormDetail.Col_Class,clas);
        contentValues.put(FormContents.NewFormDetail.Col_Mark, mark);
        db.insert(FormContents.NewFormDetail.Table_Name, null, contentValues);
        Log.e("DATABASE OPERATIONS", "Row Inserted successfully");

    }

    public Cursor showRecords(SQLiteDatabase db){
    Cursor cursor;
       String[] listOfRecord =new String[]{"Rollno","Studentname","Addres","Class","Marks"};
        cursor = db.query(FormContents.NewFormDetail.Table_Name,listOfRecord,null,null,null,null,null);
        return cursor;

    }

    public Cursor findRecord(SQLiteDatabase db,String rolno)
    {
        this.rolno=rolno;
        Cursor cursor;
        String[] listOfRecord =new String[]{"Rollno","Studentname","Addres","Class","Marks"};
        cursor = db.query(FormContents.NewFormDetail.Table_Name,listOfRecord,"Rollno="+rolno,null,null,null,null);
        return cursor;

    }

    public int deleteRec(SQLiteDatabase db, String rolno) {
        this.rolno = rolno;
        int cursor=db.delete(FormContents.NewFormDetail.Table_Name,"Rollno="+rolno,null); // for perticuler
        //int cursor=db.delete(FormContents.NewFormDetail.Table_Name,null,null);// for all records
       return cursor;
    }


    public int updateRec(SQLiteDatabase db, String rollno,String name,String address,String clas,String mark){



        ContentValues contentValues=new ContentValues();
        contentValues.put(FormContents.NewFormDetail.Col_Roll,rollno);
        contentValues.put(FormContents.NewFormDetail.Col_Name,name);
        contentValues.put(FormContents.NewFormDetail.Col_Add,address);
        contentValues.put(FormContents.NewFormDetail.Col_Class,clas);
        contentValues.put(FormContents.NewFormDetail.Col_Mark, mark);
        this.rolno=rollno;
       int cursor =db.update(FormContents.NewFormDetail.Table_Name, contentValues ,"Rollno='" +rollno+ "'",null);

        return cursor;

    }


}
