//package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;
//
//
//
//import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
//import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class СreateExpandableListView  {
//
////    public String[] masFromCity;
////    public String[] masToCity;
////    int in;
////    String txt;
////    FromCity fromCity;
////    ToCity toCity;
//    //колекция для временного хранения подсписка
////    public ArrayList<Map<String, String>> childDataItem;
////    // сдесь будет хранится списки from_city и to_city
////    public  ArrayList<ArrayList<Map<String, String>>> childData;
////    // список атрибутов группы или элемента(Для переборки)
////    Map<String, String> m;
////
////    public String toString(int in){
////        txt=""+in;
////        return txt;
////    }
////    // метод слздает масив masFromCity
////    private void createMasivesFC(){
////        masFromCity = new String[2];
////
////        in = fromCity.getId();
////        toString(in);
////        masFromCity[0] = txt;
////
////        in = fromCity.getHighlight();
////        toString(in);
////        masFromCity[1] = txt;
////        masFromCity[2] = fromCity.getName();
////    }
////
////    // Метод создает масив masToCity
////    private void createMasivesTC(){
////        masToCity = new String[2];
////
////        in = toCity.getId();
////        toString(in);
////        masToCity[0] = txt;
////
////        in = toCity.getHighlight();
////        toString(in);
////        masToCity[1] = txt;
////        masToCity[2] = toCity.getName();
////    }
////
////    // Метод создает общую колекцию элементов
////    public void CreatingСollectioтElements(){
////    childDataItem = new ArrayList<Map<String, String>>();
////    // заполняем список атрибутов для каждого элемента
////        for (String phone : masFromCity) {
////        m = new HashMap<String, String>();
////        m.put("phoneName", phone); // название телефона
////        childDataItem.add(m);
////    }
////    }
//
//    Response response = new Response();
//    ArrayList datalist = response.getDataLis();
//
//    // коллекция для групп
//    public ArrayList<Map<String, String>> groupData;
//    //RecycleListView listData;
//    // общая коллекция для коллекций элементов
//    public ArrayList<ArrayList<Map<String, String>>> childData;
//    // коллекция для элементов одной группы
//    public ArrayList<Map<String, String>> childDataItem;
//    // в итоге получится childData = ArrayList<childDataItem>
//    private Map<String, String> map;
//
//    public String groupDataFrom[], childFrom[];
//    int groupTo[], childTo[];
//
//
//    public void Test() {
//
//
//        for(int i = 0; i<datalist.size(); i++){
//            map = new HashMap<String, String>();
//            map.put("dataname", datalist.);
//            groupData.add(map);
//        }
//        groupDataFrom = new String[]{"dataName"};
//        groupTo = new int[]{android.R.id.text1};
//
//
//
//
//    }
//}
