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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProductsArray{
    private String title;
    private String img;
    private String price;
    private String minidescription;


    public ProductsArray(String titleT, String imgT, String priceT, String minidescriptionT){
        this.title = titleT;
        this.img = imgT;
        this.price = priceT;
        this.minidescription = minidescriptionT;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String titleT) {
        this.title = titleT;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String imgT) {
        this.img = imgT;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String priceT) {
        this.price = priceT;
    }

    public String getMinidescription() {
        return minidescription;
    }
    public void setMinidescription(String minidescriptionT) {
        this.minidescription = minidescriptionT;
    }

}
public class ProductsActivity extends AppCompatActivity {
    private String search = "";
    DBHelper_Products dbHelper;
    TextView Title;
    ImageView img;
    TextView Price;
    TextView miniDescription;
    ScrollView scrollView;
    ListView listView;
    List<String> list;
    String title;
    int position;
    List<String> titleArr;
    List<String> priceArr;
    List<Integer> imgArr;
    List<String> minidescription;
    List<Integer> idArr;
    HashMap<Integer, ProductsArray> hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        search = intent.getStringExtra("search");

        Title = (TextView) findViewById(R.id.Title);
        img = (ImageView) findViewById(R.id.icon);
        Price = (TextView) findViewById(R.id.Price);
        miniDescription = (TextView) findViewById(R.id.minidescription);
        listView = (ListView) findViewById(R.id.listView);
        scrollView = (ScrollView) findViewById(R.id.scroll);

        listView.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        list = new ArrayList<String>();
        titleArr = new ArrayList<String>();
        priceArr = new ArrayList<String>();
        imgArr = new ArrayList<Integer>();
        minidescription = new ArrayList<String>();
        idArr = new ArrayList<Integer>();
        Read();
    }

    public void Read(){
        dbHelper = new DBHelper_Products(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor query = database.rawQuery("SELECT * FROM table_products "+ search + ";", null);
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
                idArr.add(Integer.parseInt(query.getString(0)));
                titleArr.add(query.getString(1));
                priceArr.add("Ціна: " + query.getString(2) + " грн.");
                String imgName = query.getString(5);
                imgArr.add(getResources().getIdentifier(imgName , "mipmap", getPackageName()));
                minidescription.add("Короткий опис: " + query.getString(4));
                i++;
            }
            while (query.moveToNext());
        }
        else {
            listView.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            Title.setText("Нічого не знайдено або дана категорія ще не додана");
            img.setVisibility(View.GONE);
            miniDescription.setText("");
            Price.setText("");
            Button button = (Button) findViewById(R.id.button11);
            button.setVisibility(View.GONE);
        }
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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                ProductsActivity.this,
                android.R.layout.simple_list_item_1,
                list );

        listView.setAdapter(arrayAdapter);
        */
        CustomListAdapter adapter=new CustomListAdapter(this, titleArr, imgArr, priceArr);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                //title = parent.getAdapter().getItem(position).toString();
                position = pos;
                listView.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Find();

            }
        });
    }
    public void Find(){
        Title.setText(titleArr.get(position));
        img.setImageResource(imgArr.get(position));
        miniDescription.setText(minidescription.get(position));
        Price.setText(priceArr.get(position));
    }
    public void Product(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("search", " where `id` = '" + idArr.get(position) + "'");
        startActivity(intent);
    }
}
