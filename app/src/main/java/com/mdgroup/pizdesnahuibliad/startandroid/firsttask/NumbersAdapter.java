package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;

import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {

    private static int viewHolderCount;
    private int numberItems;
    private Response response;
    private ArrayList<Data> dataArrayList;

    public NumbersAdapter(int numberOfItems, ArrayList<Data> dataArrayList){
        numberItems = numberOfItems;
        this.dataArrayList = dataArrayList;
        viewHolderCount = 0;
    }

    //Метод который гинерирует компонент из файла number_list_item
    // оборочиваем сгенерированый компонент в NewHolder(елемент списка с значением)
    // и присваиваем компоненту значение tv_view_holder_number(Счетчик)
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForLisItem = R.layout.number_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        //Создаем новый элемент списка
        View view = inflater.inflate(layoutIdForLisItem, viewGroup, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
//        response = new Response();
//        for(int el=0; el<dataArrayList.size();el++){
//
//            viewHolder.viewHolderIndex.setText("ViewHolder index" + dataArrayList.get(el));
//        }
        //Вставить сюда элемент из Json файла
        viewHolder.viewHolderIndex.setText("ViewHolder index " + dataArrayList);

        viewHolderCount++;
        return viewHolder;

    }

    //при прокрутке обновляем значени Holdera (меняем значение listNumberView)
    @Override
    public void onBindViewHolder(NumberViewHolder numberViewHolder, int position) {
        numberViewHolder.bind(position);

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder{

        TextView listNumberView;
        TextView viewHolderIndex;

        public NumberViewHolder(View itemView) {
            super(itemView);

            listNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);
        }

        void bind(int listIndex){
            listNumberView.setText(String.valueOf(listIndex));
        }
    }
}
