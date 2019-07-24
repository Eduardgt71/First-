package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model;

import java.util.ArrayList;

public class Response {
    // По завершению Прасинга мы получаем из JSON файла список List<Data> (Результат)
    // В этом Классе инициализирован список dataLis и описаны гетеры и сетеры для него

    private ArrayList<Data> dataList = null;

    public ArrayList<Data> getDataList(){return dataList;}
    public void setDataList(ArrayList<Data> dataList){this.dataList = dataList;}
}
