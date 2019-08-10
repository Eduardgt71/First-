package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;

import java.util.ArrayList;


public class ProgressFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public RecyclerView numbersList;
    private SwipeRefreshLayout swipeLayout;
    private ListSelection listSelection;
    private ListSelection.CacheInterface cacheInterface;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        swipeLayout = view.findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeColors(android.R.color.holo_green_dark,
                android.R.color.holo_red_dark,
                android.R.color.holo_blue_dark,
                android.R.color.holo_orange_dark);

        numbersList = view.findViewById(R.id.rv_numbers);
        numbersList.setVisibility(View.VISIBLE);



          if(savedInstanceState == null || savedInstanceState.containsKey("list")){
        //Создание списка
        listSelection = new ListSelection(getContext(), new ListSelection.CacheInterface() {
            @Override
            public void onSuccessful(ArrayList<Data> dataList) {
                reloadAdapter(dataList);
            }
        });
        listSelection.selection();


        }else {
            //   String mData = savedInstanceState.getString("text");

            ArrayList datalist = savedInstanceState.getParcelableArrayList("list");
            reloadAdapter(datalist);
        }
        return view;
    }

//    // Метод в котором я сохраняю данные для передачу в горизонтальное активити(поворотЕкрана)
//    @Override
//    public void onSaveInstanceState(final Bundle outState) {
//        super.onSaveInstanceState(outState);
//       listSelection =  new ListSelection(getContext(), new ListSelection.CacheInterface(){
//            @Override
//            public void onSuccessful(ArrayList<Data> dataList) {
//                ArrayList arrayList = dataList;
//                outState.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) arrayList);
//            }});
//    }

    // перезагрузка адаптера
    void reloadAdapter(ArrayList<Data> dataList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        numbersList.setLayoutManager(linearLayoutManager);
        NumbersAdapter listAdapter = new NumbersAdapter(dataList);
        numbersList.setAdapter(listAdapter);
    }

    @Override
    // Обновление по свайпу
    public void onRefresh() {
        new NetworkProgressTask(getContext(), new TaskInterface() {
            @Override
            public void onSuccessful(Response response) {
                if (cacheInterface != null) cacheInterface.onSuccessful(response.getDataList());
            }
        }).execute("https://gist.githubusercontent.com/pavel-zlotarenchuk/2eefe88a5fbf5519e2cb98d1062d7104/raw/a833d16ba01cb740d0e029e8698ee611ffbfa172/testtesk");
        //Останавливаем обновление:
        swipeLayout.setRefreshing(false);
    }
}

