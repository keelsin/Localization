package com.alleyne.localization;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMap(View v){
        String country = getResources().getString(R.string.country);
        Uri geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(country));
        Intent geoIntent = new Intent(Intent.ACTION_VIEW);

        geoIntent.setData(geoLocation);
        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }
    }

    public void launchMapActivity(View v){
        Intent i = new Intent(this, MapActivity.class);
        logIt(getResources().getString(R.string.country));
        i.putExtra("COUNTRY",getResources().getString(R.string.country));

        startActivity(i);
    }

    public static void logIt(String msg) {
        final String TAG = "INTCOUNTRY";
        Log.d(TAG, msg);
    }
}
