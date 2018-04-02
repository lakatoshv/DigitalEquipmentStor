package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {
    private String search = "";
    DBHelper_Products dbHelper;
    TextView Title;
    ImageView img;
    TextView Price;
    TextView Virobnik;
    TextView Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        search = intent.getStringExtra("search");
        Title = (TextView) findViewById(R.id.Title);
        img = (ImageView) findViewById(R.id.icon);
        Price = (TextView) findViewById(R.id.Price);
        Virobnik = (TextView) findViewById(R.id.brand);
        Description = (TextView) findViewById(R.id.minidescription);
        Read();
    }
    public void Read(){
        dbHelper = new DBHelper_Products(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor query = database.rawQuery("SELECT * FROM table_products "+ search + ";", null);
        if(query.moveToFirst()){
            int i = 0;
            do{
                Title.setText(query.getString(1));
                Price.setText("Ціна: " + query.getString(2) + " грн.");
                Virobnik.setText("Виробник: " + query.getString(3));
                String imgName = query.getString(5);
                img.setImageResource((getResources().getIdentifier(imgName , "mipmap", getPackageName())));
                Description.setText("Опис: " + query.getString(6));
                i++;
            }
            while (query.moveToNext());
        }
        else {
            Title.setText("Нічого не знайдено або дана категорія ще не додана");
            img.setVisibility(View.GONE);
            Description.setText("");
            Virobnik.setText("");
            Price.setText("");
        }
        query.close();
        database.close();
    }

}
