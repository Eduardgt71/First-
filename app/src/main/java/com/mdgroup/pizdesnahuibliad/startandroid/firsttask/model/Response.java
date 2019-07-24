package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model;

import java.util.ArrayList;

public class Response {
    // По завершению Прасинга мы получаем из JSON файла список List<Data> (Результат)
    // В этом Классе инициализирован список dataLis и описаны гетеры и сетеры для него

    private ArrayList<Data> dataLis = null;

    public ArrayList<Data> getDataLis(){return dataLis;}
    public void setDataLis(ArrayList<Data> dataLis){this.dataLis = dataLis;}
}
