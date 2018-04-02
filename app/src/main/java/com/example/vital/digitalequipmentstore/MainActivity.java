package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AllProducts(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        ProductsActivity productsActivity = new ProductsActivity();
        intent.putExtra("search", "Всі товари");
        startActivity(intent);
    }
    public void Category(View view) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }
    public void Search(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    public void News(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
}
