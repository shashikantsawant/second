package com.spoton.soliteapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;


public class DataListActivity extends Activity implements AdapterView.OnItemClickListener {
     ListView listView;
     SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListDataAdapter listdataadapter;
  String rol=null;
 public static final String EXTRA_ID="com.spoton.soliteleaddlication.Rollno";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_data_list);
        listView=(ListView) findViewById(R.id.list_view);
        listdataadapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listdataadapter);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();

         listView.setOnItemClickListener(this);

        cursor = databaseHelper.showRecords(sqLiteDatabase);
         if(cursor.moveToFirst()) {
             do {
                 String rno, name, add, clas, marks;
                 rno = cursor.getString(0);
                 name = cursor.getString(1);
                 add = cursor.getString(2);
                 clas = cursor.getString(3);
                 marks = cursor.getString(4);
                 DateProvider dataprovider = new DateProvider(rno, name, add, clas, marks);
                 listdataadapter.add(dataprovider);
             } while (cursor.moveToNext());
         }
    }






    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE: // Yes button clicked
                        int cursor = databaseHelper.deleteRec(sqLiteDatabase,rol);
                        listdataadapter.removeItemAtPosition(position);
                        Toast.makeText(DataListActivity.this,cursor+"Successfully", Toast.LENGTH_LONG).show();
                        Toast.makeText(DataListActivity.this, "Delete Clicked", Toast.LENGTH_LONG).show();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:  // No button clicked
                    // do nothing
                        Toast.makeText(DataListActivity.this, "Update Clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DataListActivity.this,FormDetails.class);
                        startActivity(intent);
                        break;
                }
                   }
                };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                 builder.setMessage("You want to-?")
                .setPositiveButton("Delete", dialogClickListener)
                .setNegativeButton("Update", dialogClickListener).show();

         rol=((TextView) view.findViewById(R.id.rid)).getText().toString();
        Toast.makeText(getApplicationContext(), String.valueOf(id)+"="+rol, Toast.LENGTH_LONG).show();


     }
}