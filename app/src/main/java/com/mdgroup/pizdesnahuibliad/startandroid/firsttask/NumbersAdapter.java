package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;


import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {


    private int numberItems;
    private ArrayList<Data> dataArrayList;

    public NumbersAdapter(int numberOfItems, ArrayList<Data> dataArrayList){
        numberItems = numberOfItems;
        this.dataArrayList = dataArrayList;

    }

    //Метод который гинерирует компонент из файла number_list_item
    // оборочиваем сгенерированый компонент в NewHolder(елемент списка с значением)
    // и присваиваем компоненту значение tv_view_holder_number(Счетчик)
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForLisItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForLisItem, viewGroup, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        return viewHolder;

    }

    //при прокрутке обновляем значени Holdera (меняем значение listNumberView)
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
Data data = dataArrayList.get(position);

            holder.idTextView.setText(data.getId().toString());
            holder.fromCityTextView.setText(data.getFromCity().getName());
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder{

        TextView idTextView;
        TextView fromCityTextView;


        public NumberViewHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.idTextView);
            fromCityTextView = itemView.findViewById(R.id.fromCityTextView);

        }
    }
}
