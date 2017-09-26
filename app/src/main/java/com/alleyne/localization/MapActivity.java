package com.alleyne.localization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Keylen on 2017-09-26.
 */

public class MapActivity extends AppCompatActivity{
    EditText etLocal;
    TextView errors;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        etLocal = (EditText)findViewById(R.id.local);
        errors = (TextView)findViewById(R.id.error);
        button = (Button)findViewById(R.id.button);
    }

    protected boolean validate(View v){
        if(etLocal.getText().toString().isEmpty()) {
            errors.setText(R.string.error);
            return false;
        }
        return true;
    }
}
