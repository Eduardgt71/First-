package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Клас в котором создается База данных myDataBase
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context){
        super(context, "myDataBase",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data("
                + "id INTEGER primary key autoincrement,"
                + "data_id INTEGER,"
                + "from_city_highlight INTEGER,"
                + "from_city_id INTEGER,"
                + "from_city_name TEXT,"
                + "from_date TEXT,"
                + "from_time TEXT,"
                + "from_info TEXT,"
                + "to_city_highlight INTEGER,"
                + "to_city_id INTEGER,"
                + "to_city_name TEXT,"
                + "to_date TEXT,"
                + "to_time TEXT,"
                + "to_info TEXT,"
                + "info TEXT,"
                + "price INTEGER,"
                + "bus_id INTEGER,"
                + "reservation_count INTEGER" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
