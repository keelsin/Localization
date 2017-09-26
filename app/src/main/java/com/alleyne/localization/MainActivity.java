package com.alleyne.localization;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //This is a quick test in to see if using gitbash really does change branches by itself: This was done in localSearch
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
}
