package com.spoton.soliteapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by shashi on 1/13/16.
 */
public class FindPerticuler extends Activity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListDataAdapter listdataadapter;
    String rolno=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data_list);
        if(getIntent().getExtras()!=null)
        {
         rolno=getIntent().getExtras().getString("Rollno","");
        }
        listView=(ListView) findViewById(R.id.list_view);
        listdataadapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listdataadapter);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.findRecord(sqLiteDatabase,rolno);
        if(cursor.getCount() > 0)
        {
        Toast.makeText(this,"Record Found...!",Toast.LENGTH_LONG).show();
        if(cursor.moveToFirst())
        {
            do{
                String rno,name,add,clas,marks;
                rno=cursor.getString(0);
                name=cursor.getString(1);
                add=cursor.getString(2);
                clas=cursor.getString(3);
                marks=cursor.getString(4);
                DateProvider dataprovider=new DateProvider(rno,name,add,clas,marks);
                listdataadapter.add(dataprovider);
            }while(cursor.moveToNext());
        }
    }
        else{Toast.makeText(this,"Record not Found...!!!",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,InputId.class);
            startActivity(intent);

        }


    }

}
