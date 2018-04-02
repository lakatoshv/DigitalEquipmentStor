package com.example.vital.digitalequipmentstore;

/**
 * Created by vital on 19.03.2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper_News extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DigitalEquipmentStore";

    public static final String TABLE_NEWS = "news";

    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TEXT = "text";
    public static final String KEY_DATE = "date";

    public DBHelper_News(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `news` (`title` varchar(100) NOT NULL, `text` text NOT NULL, `date` datetime NOT NULL" + ")");
        db.execSQL("INSERT INTO `news` (`title`, `text`, `date`) VALUES\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-10 10:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-12 16:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-10 10:09:49'),\n" +
                "('Бонус на рахунок при покупці Nokia', 'При покупці телефона Nokia ви отримуєте бонусні 100 гривень на рахунок', '2017-01-12 16:09:49');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NEWS);
        onCreate(db);
    }
}
