package com.spoton.soliteapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shashi on 1/12/16.
 */
public class FormDetails extends Activity{
 EditText editText,editText2,editText3,editText4,editText5;
    Context context=this;
    Cursor cursor;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_detail);

        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=(EditText) findViewById(R.id.editText3);
        editText4=(EditText) findViewById(R.id.editText4);
        editText5=(EditText) findViewById(R.id.editText5);

    }

   public void save(View view)
   {
              String  etroll=editText.getText().toString();
              String  etname=editText2.getText().toString();
              String etadd=editText3.getText().toString();
              String etclass=editText4.getText().toString();
              String etmark=editText5.getText().toString();
   if((etroll.compareTo("")!=0) && (etname.compareTo("")!=0) && (etadd.compareTo("")!=0) && (etclass.compareTo("")!=0) && (etroll.compareTo("")!=0))
        {
          databaseHelper = new DatabaseHelper(context);
          sqLiteDatabase = databaseHelper.getWritableDatabase();

          cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + FormContents.NewFormDetail.Table_Name + " WHERE Rollno ='" + etroll + "'", null);

       if (cursor.moveToFirst()) {
           Toast.makeText(getBaseContext(), "Record is exist alredy so...", Toast.LENGTH_LONG).show();
           databaseHelper.updateRec(sqLiteDatabase, etroll, etname, etadd, etclass, etmark);
           databaseHelper.close();
           Toast.makeText(this, "Record Upadeted Successfully", Toast.LENGTH_LONG).show();
       } else {
           // Insert rec
           databaseHelper.adRecord(etroll, etname, etadd, etclass, etmark, sqLiteDatabase);
           Toast.makeText(getBaseContext(), "Date saved successflly", Toast.LENGTH_LONG).show();
           databaseHelper.close();
       }

       Intent intent = new Intent(this, MainSqliteActivity.class);
       startActivity(intent);
     }else{Toast.makeText(getBaseContext()," Fill All TextField Plz...!", Toast.LENGTH_LONG).show();}

   }

}
