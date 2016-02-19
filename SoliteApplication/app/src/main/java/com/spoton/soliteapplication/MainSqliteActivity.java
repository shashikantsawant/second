package com.spoton.soliteapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainSqliteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
    }

    public void add(View view)
    {

       Intent intent=new Intent(this,FormDetails.class);
        startActivity(intent);
    }
public void viewRec(View view){

    Intent intent=new Intent(this,DataListActivity.class);
    startActivity(intent);

}
    public void search(View view){

        Intent intent=new Intent(this,InputId.class);
        startActivity(intent);

    }

    public void deleteToMain(View view)
    {
        Intent intent=new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }
    public void updateToMain(View view)
    {
        Intent intent=new Intent(this,FormDetails.class);
        startActivity(intent);
    }

}
