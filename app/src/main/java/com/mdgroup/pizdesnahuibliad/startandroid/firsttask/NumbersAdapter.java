package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.FromCity;


import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {


    private int numberItems;
    private ArrayList<Data> dataArrayList;

    // конструктор
    public NumbersAdapter(int numberOfItems, ArrayList<Data> dataArrayList) {
        numberItems = numberOfItems;
        this.dataArrayList = dataArrayList;

    }

    //Метод который гинерирует компонент из файла number_list_item
    // оборочиваем сгенерированый компонент в NewHolder(елемент списка с значением)
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForLisItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForLisItem, viewGroup, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        return viewHolder;

    }

    //при прокрутке обновляем значени Holdera (меняем значение полей текст Вайв)
    // передаем в текстВиев элементы джисона
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Data data = dataArrayList.get(position);


        holder.idTextView.setText(data.getId().toString());

        holder.fromCityTextView.setText(data.getFromCity().getName());
        holder.fromCityIdTextView.setText(data.getFromCity().getId().toString());
        holder.fromCityHighlightTextView.setText(data.getFromCity().getHighlight().toString());

        holder.fromDateTextView.setText(data.getFrom_date().toString());
        holder.fromTimeTextView.setText(data.getFrom_time().toString());
        holder.fromInfoTextView.setText(data.getFrom_info().toString());

        holder.toCityTextView.setText(data.getToCity().getName());
        holder.toCityIdTextView.setText(data.getToCity().getId().toString());
        holder.toCityHighlightTextView.setText(data.getToCity().getHighlight().toString());

        holder.toDateTextView.setText(data.getTo_date().toString());
        holder.toTimeTextView.setText(data.getTo_time().toString());
        holder.toInfoTextView.setText(data.getTo_info().toString());
        holder.InfoTextView.setText(data.getInfo().toString());
        holder.priceTextView.setText(data.getPrice().toString());
        holder.busIdTextView.setText(data.getBus_id().toString());
        holder.reservationCountTextView.setText(data.getReservation_count().toString());




    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    //Класс в котором реализуем что будет входить в холдер, в танном случаи холдер состоит из множества
    // текст вайф
    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView idTextView,

                fromCityTextView,
                        fromCityIdTextView,
                        fromCityHighlightTextView,
                fromDateTextView,
                fromTimeTextView,
                fromInfoTextView,
                toCityTextView,
                        toCityIdTextView,
                        toCityHighlightTextView,
                toDateTextView,
                toTimeTextView,
                toInfoTextView,
                InfoTextView,
                priceTextView,
                busIdTextView,
                reservationCountTextView;



        public NumberViewHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.idTextView);

            fromCityTextView = itemView.findViewById(R.id.fromCityTextView);
            fromCityIdTextView = itemView.findViewById(R.id. fromCityIdTextView);
            fromCityHighlightTextView = itemView.findViewById(R.id. fromCityHighlightTextView);

            fromDateTextView = itemView.findViewById(R.id.fromDateTextView);
            fromTimeTextView = itemView.findViewById(R.id.fromTimeTextView);
            fromInfoTextView = itemView.findViewById(R.id.fromInfoTextView);

            toCityTextView = itemView.findViewById(R.id.toCityTextView);
            toCityIdTextView = itemView.findViewById(R.id.toCityIdTextView);
            toCityHighlightTextView = itemView.findViewById(R.id.toCityHighlightTextView);

            toDateTextView = itemView.findViewById(R.id.toDateTextView);
            toTimeTextView = itemView.findViewById(R.id.toTimeTextView);
            toInfoTextView = itemView.findViewById(R.id.toInfoTextView);
            InfoTextView = itemView.findViewById(R.id.infoTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            busIdTextView = itemView.findViewById(R.id.bus_idTextView);
            reservationCountTextView = itemView.findViewById(R.id.reservationCountTextView);



        }
    }
}
