package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.fileManager;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;


public class FileManager {
    public String jsonString;
    private  Context context;

    public FileManager(Context context) {
        this.context = context;
    }

    private final static String FILE_NAME = "json.txt";
//    public File CreateFile() {
//         try {
//            String PATH = Environment.getExternalStorageDirectory().getPath() + "/" + BuildConfig.APPLICATION_ID + "/json.txt";
//            File file = new File(PATH);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//             return file;
//        }catch (IOException e){
//             Log.d ("exeption", e.toString());
//         }
//        return null;
//    }

    public void writeFile(String jsonString)  {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());
            Toast.makeText(context, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fileOutputStream!=null)
                    fileOutputStream.close();
            }
            catch(IOException ex){

                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    // открытие файла
    public String readFile(){

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(FILE_NAME);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            jsonString = new String (bytes);
            return jsonString;
        }
        catch(IOException ex) {

            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fileInputStream!=null)
                    fileInputStream.close();
            }
            catch(IOException ex){
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }
    // Проверяем наличие файла
    public boolean getFolderSize() {
    if(null != jsonString) {
            return true;
        }else{return false;}
    }
}
