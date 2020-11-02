package com.hencesimplified.wallpaperpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        Intent page_intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(page_intent);
        return true;
    }

    @Override

    public void onBackPressed() {
        finish();
        Intent page_intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(page_intent);
    }

}
