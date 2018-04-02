package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ProductsActivity extends AppCompatActivity {
    private String search = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView result = (TextView) findViewById(R.id.show);
        Intent intent = getIntent();
        search = intent.getStringExtra("search");
        if(search != null || search.trim().length() != 0){
            result.setText(search);
        }
    }

}
