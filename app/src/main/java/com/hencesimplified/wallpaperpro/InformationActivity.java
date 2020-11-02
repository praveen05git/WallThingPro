package com.hencesimplified.wallpaperpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        Intent page_intent = new Intent(InformationActivity.this, MainActivity.class);
        startActivity(page_intent);
        return true;
    }

    @Override

    public void onBackPressed() {
        finish();
        Intent page_intent = new Intent(InformationActivity.this, MainActivity.class);
        startActivity(page_intent);
    }

}
