package com.example.vital.digitalequipmentstore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.sax.Element;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class NewsArray{
    private String title;
    private String text;
    private String date;


    public NewsArray(String titleT, String textT, String dateT){
        this.title = titleT;
        this.text = textT;
        this.date = dateT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titleT) {
        this.title = titleT;
    }
    public String getText() {
        return text;
    }

    public void setText(String textT) {
        this.text = textT;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String dateT) {
        this.date = dateT;
    }

}
public class NewsActivity extends AppCompatActivity {
    DBHelper_News dbHelper;
    TextView Title;
    TextView Body;
    TextView Date;
    LinearLayout linearLayout;
    ListView listView;
    List<String> list;
    String title;
    HashMap<Integer, NewsArray> hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Title = (TextView) findViewById(R.id.Title);
        Body = (TextView) findViewById(R.id.Body);
        Date = (TextView) findViewById(R.id.Date);
        listView = (ListView) findViewById(R.id.listView);
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        listView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);

        list = new ArrayList<String>();
        Read();
    }
    public void Find(){
        dbHelper = new DBHelper_News(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor query = database.rawQuery("SELECT * FROM news where `title` = '" + title +"';", null);
        if(query.moveToFirst()){
            int i = 0;
            do{
                ///hm = new HashMap<Integer, NewsArray>();
                String titleQuery = query.getString(0);
                String text = query.getString(1);
                String date = query.getString(2);
                Title.setText(title);
                Body.setText(text);
                Date.setText(date);
                i++;
            }
            while (query.moveToNext());
        }
        else Log.d("mLog", "0 rows");
        query.close();
        database.close();
    }
    public void Read(){
        dbHelper = new DBHelper_News(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor query = database.rawQuery("SELECT * FROM news;", null);
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
                NewsActivity.this,
                android.R.layout.simple_list_item_1,
                list );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title = parent.getAdapter().getItem(position).toString();
                //textViewTitle.setText(parent.getAdapter().getItem(position).toString());
                listView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
                Find();

            }
        });
    }

}
