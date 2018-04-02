package com.example.vital.digitalequipmentstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vital on 01.04.2018.
 */
public class DBHelper_Products extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Products";

    public static final String TABLE_PRODUCTS = "table_products";


    public DBHelper_Products(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `table_products` (" +
                   "`id` INTEGER PRIMARY KEY, " +
                   "`title` text NOT NULL, " +
                   "`price` text NOT NULL, " +
                   "`brand` text NOT NULL, " +
                   "`mini_description` text NOT NULL, " +
                   "`image` text NOT NULL, " +
                   "`description` text NOT NULL, " +
                   "`type_tovara` text NOT NULL) ");
        db.execSQL("INSERT INTO `table_products` (`title`, `price`, `brand`, `mini_description`, `image`, `description`, `type_tovara`) VALUES\n" +
                "('Samsung Galaxy J2', '1295', 'Samsung', 'Для активного пользователя мобильными устройствами нет ничего лучше, чем мощный и красивый смартфон. Обладающее продуманной эргономикой и высокой производительностью устройство понравится как искушенному пользователю, так и новичку, который только присматривает свой первый хороший смартфон. Южнокорейский смартфон Samsung Galaxy J7 SM-J700H порадует пользователя широким функционалом, а также удобной, интуитивно понятной OS Android.', 'samsung_galaxy_j7_1', 'Диагональ экрана: 5.5\"; Разрешение экрана: 1280x720; Камера: 13 Mpx; Количество ядер: 8;', 'mobile'),\n" +
                "('Samsung Galaxy J3', '3299', 'Samsung', 'Для активного пользователя мобильными устройствами нет ничего лучше, чем мощный и красивый смартфон. Обладающее продуманной эргономикой и высокой производительностью устройство понравится как искушенному пользователю, так и новичку, который только присматривает свой первый хороший смартфон. Южнокорейский смартфон Samsung Galaxy J7 SM-J700H порадует пользователя широким функционалом, а также удобной, интуитивно понятной OS Android.', 'samsung_galaxy_j7_1', 'Диагональ экрана: 5.5\"; Разрешение экрана: 1280x720; Камера: 13 Mpx; Количество ядер: 8;', 'mobile'),\n" +
                "('Samsung Galaxy J4', '4299', 'Samsung', 'Для активного пользователя мобильными устройствами нет ничего лучше, чем мощный и красивый смартфон. Обладающее продуманной эргономикой и высокой производительностью устройство понравится как искушенному пользователю, так и новичку, который только присматривает свой первый хороший смартфон. Южнокорейский смартфон Samsung Galaxy J7 SM-J700H порадует пользователя широким функционалом, а также удобной, интуитивно понятной OS Android.', 'samsung_galaxy_j7_1', 'Диагональ экрана: 5.5\"; Разрешение экрана: 1280x720; Камера: 13 Mpx; Количество ядер: 8;', 'mobile'),\n" +
                "('Samsung Galaxy J5', '2299', 'Samsung', 'Для активного пользователя мобильными устройствами нет ничего лучше, чем мощный и красивый смартфон. Обладающее продуманной эргономикой и высокой производительностью устройство понравится как искушенному пользователю, так и новичку, который только присматривает свой первый хороший смартфон. Южнокорейский смартфон Samsung Galaxy J7 SM-J700H порадует пользователя широким функционалом, а также удобной, интуитивно понятной OS Android.', 'samsung_galaxy_j7_1', 'Диагональ экрана: 5.5\"; Разрешение экрана: 1280x720; Камера: 13 Mpx; Количество ядер: 8;', 'mobile'),\n" +
                "('Samsung Galaxy J6', '5299', 'Samsung', 'Для активного пользователя мобильными устройствами нет ничего лучше, чем мощный и красивый смартфон. Обладающее продуманной эргономикой и высокой производительностью устройство понравится как искушенному пользователю, так и новичку, который только присматривает свой первый хороший смартфон. Южнокорейский смартфон Samsung Galaxy J7 SM-J700H порадует пользователя широким функционалом, а также удобной, интуитивно понятной OS Android.', 'samsung_galaxy_j7_1', 'Диагональ экрана: 5.5\"; Разрешение экрана: 1280x720; Камера: 13 Mpx; Количество ядер: 8;', 'mobile');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_PRODUCTS);
        onCreate(db);
    }
}
