//package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;
//
//import android.os.AsyncTask;
//import android.support.v4.app.Fragment;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//
//import javax.net.ssl.HttpsURLConnection;
//
//public class ProgressTask extends AsyncTask<String, Void, String> {
//
//    ProgressFragment progressFragment = new ProgressFragment();
//    Fragment fragment = new Fragment();
//
//    TextView contentView;
//    //String contentText = null;
//
//    protected String doInBackground(String... path) {
//
//        String content;
//        try{
//            content = getContent(path[0]);
//        }
//        catch (IOException ex){
//            content = ex.getMessage();
//        }
//
//        return content;
//    }
//       private String getContent(String path) throws IOException {
//        BufferedReader reader=null;
//        try {
//            URL url=new URL(path);
//            HttpsURLConnection c=(HttpsURLConnection)url.openConnection();
//            c.setRequestMethod("GET");
//            c.setReadTimeout(10000);
//            c.connect();
//            reader= new BufferedReader(new InputStreamReader(c.getInputStream()));
//            StringBuilder buf=new StringBuilder();
//            String line=null;
//            while ((line=reader.readLine()) != null) {
//                buf.append(line + "\n");
//            }
//            return(buf.toString());
//        }
//        finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//    }
//
//    @Override
//    protected void onPostExecute(String content) {
//        //contentText=content;
//        progressFragment.setContentText(content);
//        contentView.setText(content);
//        progressFragment.setContentView(contentView);
//        Toast.makeText(fragment.getActivity(), "Данные загружены", Toast.LENGTH_SHORT)
//                .show();
//    }
//}
//
//
//
