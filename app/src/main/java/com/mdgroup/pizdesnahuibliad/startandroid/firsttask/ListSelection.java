package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase.DBHelper;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase.ReadDataBase;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;

import java.util.ArrayList;

public class ListSelection  {

    private Context context;
    private CacheInterface cacheInterface;

    public ListSelection(Context context, CacheInterface cacheInterface){
        this.context = context;
        this.cacheInterface = cacheInterface;
    }





    // Проверяет на наличее строчек в таблице
    public void checkDataBase(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from data",null);
        Log.i("NumberRecords"," :: "+cursor.getCount());
        listSelection(cursor);
    }


    // Выбераем откуда будем брать данные для списка
    private void listSelection(Cursor cursor) {
        FileManager fileManager = new FileManager();

        if (cursor.getCount()>0){
            //Чтение таблици
            ReadDataBase readDataBase = new ReadDataBase(context);
            ArrayList<Data> datalist = readDataBase.readerDB();
            if(cacheInterface != null) cacheInterface.onSuccessful(datalist);

        } else if(fileManager.getFolderSize()) {
            new LocalFileTask(context, new TaskInterface() {
                @Override
                public void onSuccessful(Response response) {
                    if(cacheInterface != null) cacheInterface.onSuccessful(response.getDataList());
                }
            }).execute();
        }

            else{
            new NetworkProgressTask(context, new TaskInterface() {
                @Override
                public void onSuccessful(Response response) {
                    if(cacheInterface != null) cacheInterface.onSuccessful(response.getDataList());
                }
            }).execute("https://gist.githubusercontent.com/pavel-zlotarenchuk/2eefe88a5fbf5519e2cb98d1062d7104/raw/a833d16ba01cb740d0e029e8698ee611ffbfa172/testtesk");
        }
    }
    interface CacheInterface{
        void onSuccessful(ArrayList<Data> dataList);
    }
}
