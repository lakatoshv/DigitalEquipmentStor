package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void Search(View view) {
        TextView result = (TextView) findViewById(R.id.search);
        String search = result.getText().toString();
        if(search != null || search.trim().length() != 0){
            Intent intent = new Intent(this, ProductsActivity.class);
            intent.putExtra("search", "Шукане: " + search);
            startActivity(intent);
        }
    }
}
