package com.spoton.soliteapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shashi on 1/13/16.
 */
public class InputId extends Activity {
    private EditText mEditTextRollNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_id);
       mEditTextRollNo= (EditText) findViewById(R.id.editTextRollNo);
    }

    public void find(View view){

        String lRolNo= mEditTextRollNo.getText().toString();

        if(TextUtils.isEmpty(lRolNo)) {
            Toast.makeText(this,"Plz Enter Something in Text Field",Toast.LENGTH_LONG).show();
            return;
        }
        Bundle  lbundBundle=new Bundle();
        lbundBundle.putString("Rollno",lRolNo.trim());
        Intent intent=new Intent(this,FindPerticuler.class);
        intent.putExtras(lbundBundle);
        startActivity(intent);
    }
}
