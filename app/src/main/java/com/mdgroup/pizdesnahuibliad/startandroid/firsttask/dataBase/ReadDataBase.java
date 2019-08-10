package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.FromCity;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.ToCity;


import java.util.ArrayList;


public class ReadDataBase {
    private ArrayList<Data> dataListDB;
    private Context context;


    public ReadDataBase(Context context){
        this.context =context;

    }
    SQLiteDatabase db = DBHelper.getInstance(context);

    // медод чтения данных с таблици в Список
    public ArrayList readerDB() {
        try {


            db.beginTransaction();
            // Запрос к таблице
            Cursor cursor = db.query("data", null, null, null, null, null, null);
            dataListDB = new ArrayList<>();
            if (cursor.moveToFirst()) {

                int dataIdColIndex = cursor.getColumnIndex("data_id");
                int fromCityHighlightColIndex = cursor.getColumnIndex("from_city_highlight");
                int fromCityIdColIndex = cursor.getColumnIndex("from_city_id");
                int fromCityNameColIndex = cursor.getColumnIndex("from_city_name");

                int toCityHighlightColIndex = cursor.getColumnIndex("to_city_highlight");
                int toCityIdColIndex = cursor.getColumnIndex("to_city_id");
                int toCityNameColIndex = cursor.getColumnIndex("to_city_name");
                int toDateColIndex = cursor.getColumnIndex("to_date");
                while (cursor.moveToNext()) {
                    Data dataDB = new Data();
                    dataDB.setId(cursor.getInt(dataIdColIndex));

                    FromCity fromCityDB = new FromCity();
                    fromCityDB.setHighlight(cursor.getInt(fromCityHighlightColIndex));
                    fromCityDB.setId(cursor.getInt(fromCityIdColIndex));
                    fromCityDB.setName(cursor.getString(fromCityNameColIndex));
                    dataDB.setFromCity(fromCityDB);

                    dataDB.setFrom_date(cursor.getString(cursor.getColumnIndex("from_date")));
                    dataDB.setFrom_info(cursor.getString(cursor.getColumnIndex("from_time")));
                    dataDB.setFrom_time(cursor.getString(cursor.getColumnIndex("from_info")));

                    ToCity toCityDB = new ToCity();
                    toCityDB.setHighlight(cursor.getInt(toCityHighlightColIndex));
                    toCityDB.setId(cursor.getInt(toCityIdColIndex));
                    toCityDB.setName(cursor.getString(toCityNameColIndex));

                    dataDB.setToCity(toCityDB);

                    dataDB.setTo_date(cursor.getString(toDateColIndex));
                    dataDB.setTo_time(cursor.getString(cursor.getColumnIndex("to_time")));
                    dataDB.setTo_info(cursor.getString(cursor.getColumnIndex("to_info")));
                    dataDB.setInfo(cursor.getString(cursor.getColumnIndex("info")));
                    dataDB.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                    dataDB.setBus_id(cursor.getInt(cursor.getColumnIndex("bus_id")));
                    dataDB.setReservation_count(cursor.getInt(cursor.getColumnIndex("reservation_count")));
                    dataListDB.add(dataDB);

                }

            }
        } catch (SQLException e) {
            Log.d("FATAL", String.valueOf(e));
        } finally {
            db.endTransaction();
        }
        return dataListDB;
    }

}
