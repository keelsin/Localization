package com.alleyne.localization;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.SearchManager;

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
        setContentView(R.layout.activity_mapactivity);
        etLocal = (EditText)findViewById(R.id.local);
        errors = (TextView)findViewById(R.id.error);
        button = (Button)findViewById(R.id.button);
        String country = getIntent().getStringExtra("COUNTRY");
        etLocal.setText(country);
    }

    protected boolean validate(String msg){
        if(etLocal.getText().toString().isEmpty()) {
            errors.setText(msg);
            return false;
        }
        return true;
    }

    public void showMap(View v){
        if(validate(getString(R.string.error))) {
            Uri geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(etLocal.getText().toString()));
            Intent geoIntent = new Intent(Intent.ACTION_VIEW);

            geoIntent.setData(geoLocation);
            if (geoIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(geoIntent);
            }
        }
    }

    public void searchWeb(View view) {
        if(validate(getString(R.string.search_request))) {
            String query = etLocal.getText().toString();
            MainActivity.logIt(query);
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, query);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}
