package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager;

import android.content.Context;
import android.os.AsyncTask;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.TaskInterface;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.utils.JSONParser;



public class LocalFileTask extends AsyncTask<String, Void, Response> {

    private Context context;

    private TaskInterface listener;




    public LocalFileTask(Context context, TaskInterface listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected Response doInBackground(String... strings) {
        FileManager fileManager = new FileManager(context);
        String stringJsonFile = fileManager.readFile();
        //Передаем в парсер Json файл из списка
        return JSONParser.parse(stringJsonFile);
    }

    protected void onPostExecute(Response response) {
        if (listener !=null) listener.onSuccessful(response);
    }



}

