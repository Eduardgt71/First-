package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.utils.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class ProgressFragment extends Fragment {

    Button btnFetch, showList;
    FragmentTransaction fTrans;
    NumbersAdapter listAdapter;
    RecyclerView numbersList;
    ScrollView scroller;
    Response response;
    ArrayList<Data> datalist;


    TextView contentView;
    String contentText = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        contentView = view.findViewById(R.id.content);
        btnFetch = view.findViewById(R.id.downloadBtn);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentText == null) {
                    contentView.setText("Загрузка...");
                    new ProgressTask().execute("https://gist.githubusercontent.com/pavel-zlotarenchuk/2eefe88a5fbf5519e2cb98d1062d7104/raw/a833d16ba01cb740d0e029e8698ee611ffbfa172/testtesk");
                }
            }
        });
        scroller = view.findViewById(R.id.scrollView);
        numbersList = view.findViewById(R.id.rv_numbers);
        showList = view.findViewById(R.id.showListBtn);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            scroller.setVisibility(View.GONE);
            numbersList.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    public class ProgressTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... path) {
            String stringJson;
            try {
                stringJson = getContent(path[0]);
            } catch (IOException ex) {
                stringJson = ex.getMessage();
            }
            JSONParser jsonParser = new JSONParser();
            jsonParser.parse(stringJson);
            return stringJson;
        }

        @Override
        protected void onPostExecute(String content) {
            contentText = content;
            contentView.setText(content);

            response = JSONParser.parse(content);
            datalist = response.getDataList();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            numbersList.setLayoutManager(linearLayoutManager);
            listAdapter = new NumbersAdapter(300, datalist);
            numbersList.setAdapter(listAdapter);
            Toast.makeText(getActivity(), "Данные загружены", Toast.LENGTH_SHORT)
                    .show();
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


}