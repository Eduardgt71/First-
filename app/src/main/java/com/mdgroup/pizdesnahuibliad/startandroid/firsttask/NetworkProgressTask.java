package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.content.Context;
import android.os.AsyncTask;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.dataBase.WriteDataBase;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager.FileManager;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.utils.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NetworkProgressTask extends AsyncTask<String, Void, String> {

    private Context context;
    private TaskInterface listener;

    NetworkProgressTask(Context context, TaskInterface listener){
        this.context = context;
        this.listener = listener;
    }



    @Override
    protected String doInBackground(String... path) {
        String stringJson;
        try {
            stringJson = getContent(path[0]);
        } catch (IOException ex) {
            stringJson = ex.getMessage();
        }
        //Передаем в парсер Json файл в виде строки
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse(stringJson);

        //1 присваеваем переменной резулььтат выполнения метода
        Response response = JSONParser.parse(stringJson);
        //Заполнение базы данных
        WriteDataBase writeDataBase = new WriteDataBase(context);
        writeDataBase.fillingData(response);

        return stringJson;
    }

    @Override
    protected void onPostExecute(String jsonString) {
        Response response = JSONParser.parse(jsonString);
        //Записываем джисон в файл
        FileManager fileManager = new FileManager();
        fileManager.writeFile(jsonString);
        if (listener != null) listener.onSuccessful(response);
    }

    private String getContent(String path) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(path);
            HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(10000);
            c.connect();
            reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            StringBuilder buf = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buf.append(line + "\n");
            }
            return (buf.toString());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}



