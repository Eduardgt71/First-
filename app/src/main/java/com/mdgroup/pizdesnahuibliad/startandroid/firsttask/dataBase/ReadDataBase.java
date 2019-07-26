package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.FromCity;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.ToCity;


import java.util.ArrayList;


public class ReadDataBase {
    private ArrayList<Data> dataListDB;
    private Data dataDB;
    private ToCity toCityDB;
    private FromCity fromCityDB;
    private Response responseDB;
    private Cursor cursor;
    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db ;


    public ReadDataBase(Context context) {
        this.context = context;
    }

    // медод чтения данных с таблици в Список
    public Response readerDB() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();

        try {
            db.beginTransaction();
            // Запрос к таблице
            cursor = db.query("data", null, null, null, null, null, null);
            dataDB = new Data();
            fromCityDB = new FromCity();
            toCityDB = new ToCity();
            responseDB = new Response();
            dataListDB = new ArrayList<>();

            if (cursor.moveToFirst()) {

                int dataidColIndex = cursor.getColumnIndex("data_id");
                int fromCityHighlightColIndex = cursor.getColumnIndex("from_city_highlight");
                int fromCityIdColIndex = cursor.getColumnIndex("from_city_id");
                int fromCityNameColIndex = cursor.getColumnIndex("from_city_name");
                int fromDateColIndex = cursor.getColumnIndex("from_date");
                int fromTimeColIndex = cursor.getColumnIndex("from_time");
                int fromInfoColIndex = cursor.getColumnIndex("from_info");
                int toCityHighlightColIndex = cursor.getColumnIndex("to_city_highlight");
                int toCityIdColIndex = cursor.getColumnIndex("to_city_id");
                int toCityNameColIndex = cursor.getColumnIndex("to_city_name");
                int toDateColIndex = cursor.getColumnIndex("to_date");
                do {
                    dataDB.setId(cursor.getInt(dataidColIndex));
                    fromCityDB.setHighlight(cursor.getInt(fromCityHighlightColIndex));
                    fromCityDB.setId(cursor.getInt(fromCityIdColIndex));
                    fromCityDB.setName(cursor.getString(fromCityNameColIndex));
                    dataDB.setFromCity(fromCityDB);
                    dataDB.setId(cursor.getInt(fromDateColIndex));
                    dataDB.setId(cursor.getInt(fromTimeColIndex));
                    dataDB.setId(cursor.getInt(fromInfoColIndex));
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
                while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            Log.d("FATAL", String.valueOf(e));
        } finally {
            db.endTransaction();
        }
        responseDB.setDataList(dataListDB);
        return responseDB;
    }
}