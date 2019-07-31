package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import java.util.ArrayList;



public class ProgressFragment extends Fragment {

    public RecyclerView numbersList;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);


        //Создание списка
        ListSelection listSelection = new ListSelection(getContext(), new ListSelection.CacheInterface() {
            @Override
            public void onSuccessful(ArrayList<Data> dataList) {
                reloadAdapter(dataList);
            }
        });
        listSelection.checkDataBase();

        numbersList = view.findViewById(R.id.rv_numbers);
        numbersList.setVisibility(View.VISIBLE);

        return view;
    }

    void reloadAdapter(ArrayList<Data> dataList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        numbersList.setLayoutManager(linearLayoutManager);
        NumbersAdapter listAdapter = new NumbersAdapter(dataList);
        numbersList.setAdapter(listAdapter);
    }

}

