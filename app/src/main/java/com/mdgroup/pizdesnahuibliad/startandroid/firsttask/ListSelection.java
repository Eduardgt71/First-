package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
;
import android.util.Log;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase.DBHelper;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase.ReadDataBase;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager.FileManager;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager.LocalFileTask;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;

import java.util.ArrayList;

public class ListSelection {

    private Context context;
    private CacheInterface cacheInterface;

    public ListSelection(Context context, CacheInterface cacheInterface){
        this.context = context;
        this.cacheInterface = cacheInterface;
    }
    // Проверяет на наличее строчек в таблице
    private Cursor checkDataBase(){
        SQLiteDatabase db = DBHelper.getInstance(context);
        Cursor cursor = db.query("data", null,null,null,null,null,null);
        Log.i("NumberRecords"," :: "+cursor.getCount());
        return cursor;
    }
    // Выбераем откуда будем брать данные для списка
    public void selection() {
        FileManager fileManager = new FileManager(context);
        Cursor cursor = checkDataBase();

        if (cursor.getCount()>0){
            //Чтение таблици
            ReadDataBase readDataBase = new ReadDataBase(context);
            ArrayList<Data> datalist = readDataBase.readerDB();
            if(cacheInterface != null) cacheInterface.onSuccessful(datalist);
        }
        else

            if(fileManager.getFolderSize()) {
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
