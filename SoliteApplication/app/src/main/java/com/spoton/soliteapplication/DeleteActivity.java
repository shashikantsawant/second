package com.spoton.soliteapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shashi on 1/14/16.
 */
public class DeleteActivity extends Activity
{
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    int cursor;
    String rolno=null;
    private EditText eTextDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_record);
        eTextDelete = (EditText) findViewById(R.id.editTextDelete);

    }
    public void delete(View view)
           {
               rolno = eTextDelete.getText().toString();
               Toast.makeText(this,rolno,Toast.LENGTH_LONG).show();
                  if (rolno.equals("")){
                      Toast.makeText(this, "Plz Enter Something in Text Field", Toast.LENGTH_LONG).show();
                      return;
                      }

            databaseHelper = new DatabaseHelper(getApplicationContext());
            sqLiteDatabase = databaseHelper.getReadableDatabase();
            cursor = databaseHelper.deleteRec(sqLiteDatabase,rolno);

            Toast.makeText(this,cursor+"Successfully", Toast.LENGTH_LONG).show();

               Intent intent=new Intent(DeleteActivity.this,DataListActivity.class);
               startActivity(intent);

    }
}
