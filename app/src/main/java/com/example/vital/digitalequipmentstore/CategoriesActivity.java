package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void Mobile(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("search", " where `type_tovara` = 'mobile'");
        startActivity(intent);
    }
    public void Tablet(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("search", " where `type_tovara` = 'tablet'");
        startActivity(intent);
    }
    public void Laptop(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("search", " where `type_tovara` = 'laptop'");
        startActivity(intent);
    }

}
