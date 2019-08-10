package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.BuildConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;




public class FileManager extends Activity {
    public String stringJsonFile;


    public File CreateFile() {
         try {
            String PATH = Environment.getExternalStorageDirectory().getPath() + "/" + BuildConfig.APPLICATION_ID + "/json.txt";
            File file = new File(PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
             return file;
        }catch (IOException e){
             Log.d ("exeption", e.toString());
         }
        return null;
    }

    public void writeFile(String jsonString)  {
        try {
            if (CreateFile() != null){
                // отрываем поток для записи
                BufferedWriter bw = new BufferedWriter(new FileWriter(CreateFile()));
                // пишем данные
                bw.write(jsonString);
                // закрываем поток
                bw.close();
                Log.d("WRITEFILE", "Файл записан");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        try {

            // открываем поток для чтения
            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(
                    openFileInput("json")));
           stringJsonFile = "";
            // читаем содержимое
            while ((stringJsonFile = bufferedReader.readLine()) != null) {
               // Log.d("READFILE", stringJsonFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringJsonFile;
    }

    // Проверяем наличие файла
    public boolean getFolderSize() {
        if(null!=CreateFile()) {
            return CreateFile().exists();
        }else{return false;}
    }
}
