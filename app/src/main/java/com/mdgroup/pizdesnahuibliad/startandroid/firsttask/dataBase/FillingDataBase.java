package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;

import java.util.List;

public class FillingDataBase {

    private DBHelper dbHelper;
    private  SQLiteDatabase db;
    private List<Data> dataList;
    private Context context;

    public FillingDataBase(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }



    public void fillingData(Response response){
        dataList = response.getDataList();
        for(int i=0; i<dataList.size(); i++){
            Data data = dataList.get(i);
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", data.getId());
            contentValues.put("from_city_highlight", data.getFromCity().getHighlight());
            contentValues.put("from_city_id", data.getFromCity().getId());
            contentValues.put("from_city_name", data.getFromCity().getName());
            contentValues.put("from_date", data.getFrom_date());
            contentValues.put("from_time", data.getFrom_time());
            contentValues.put("from_info", data.getFrom_info());
            contentValues.put("to_city_highlight", data.getToCity().getHighlight());
            contentValues.put("to_city_id", data.getToCity().getId());
            contentValues.put("to_city_name", data.getToCity().getName());
            contentValues.put("to_date", data.getTo_date());
            contentValues.put("to_time", data.getTo_time());
            contentValues.put("to_info", data.getTo_info());
            contentValues.put("info", data.getInfo());
            contentValues.put("price", data.getPrice());
            contentValues.put("bus_id", data.getBus_id());
            contentValues.put("reservation_count", data.getReservation_count());

            long rowIdData = db.insert("data",null, contentValues);
            Log.d("FILLING", "row insert Id = "+rowIdData );
        }
    }


}