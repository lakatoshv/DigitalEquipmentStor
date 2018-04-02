package com.example.vital.digitalequipmentstore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandsActivity extends AppCompatActivity {
    DBHelper_Products dbHelper;
    ListView listView;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);

        listView = (ListView) findViewById(R.id.listView);

        listView.setVisibility(View.VISIBLE);

        list = new ArrayList<String>();
        Read();
    }
    public void Read(){
        dbHelper = new DBHelper_Products(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor query = database.rawQuery("SELECT DISTINCT brand FROM table_products;", null);
        if(query.moveToFirst()){
            int i = 0;
            do{
                ///hm = new HashMap<Integer, NewsArray>();
                String titleQuery = query.getString(0);
                //String text = query.getString(1);
                //String date = query.getString(2);
                //hm.put(i, new NewsArray(titleQuery, text, date));
            /*
                for (HashMap<Integer, NewsArray> map : hm) {
                    System.out.println(map.get("URL"));
                }
                */

                //Body.append("title: " + title + "\n Text: " + text + "\n Date: " + date + "\n\n");
                list.add(titleQuery);
                i++;
            }
            while (query.moveToNext());
        }
        else Log.d("mLog", "0 rows");
        query.close();
        database.close();
        /*
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS `news` (`title` varchar(100) NOT NULL, `text` text NOT NULL, `date` datetime NOT NULL" + ")");
        db.execSQL("INSERT INTO `news` (`title`, `text`, `date`) VALUES\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-10 10:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-12 16:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-10 10:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-12 16:09:49');");

        Cursor query = db.rawQuery("SELECT * FROM news;", null);
        if(query.moveToFirst()){
            do{
                String titleQuery = query.getString(0);
                String text = query.getString(1);
                String date = query.getString(2);
                //Body.append("title: " + title + "\n Text: " + text + "\n Date: " + date + "\n\n");
                list.add(titleQuery
                );
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
        */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                BrandsActivity.this,
                android.R.layout.simple_list_item_1,
                list );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String brand = parent.getAdapter().getItem(position).toString();
                Brand(brand);
            }
        });
    }
    public void Brand(String brand){
        Intent intent = new Intent(this, ProductsActivity.class);
        ProductsActivity productsActivity = new ProductsActivity();
        intent.putExtra("search", "where `brand` = '" + brand + "'");
        startActivity(intent);
    }
}
