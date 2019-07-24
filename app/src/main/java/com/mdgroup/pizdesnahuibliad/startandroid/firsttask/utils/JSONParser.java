package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.utils;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Data;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.FromCity;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.Response;
import com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model.ToCity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {
        // метод принимает Json файл в виде строчки, парсит и возвращает обьектную переменную коасса
        // Response ( обьектная переменная response которая хранит результат парсинга)
    public Response parse(String stringJson) {

        try {
            //Присваеваем в обьектной переменной objectResponse Json файл в виде строчки
            JSONObject objectResponse = new JSONObject(stringJson);
            // Создаем обьектную переменную класса Response (Для хранения результата парсинга)
            Response response = new Response();
            //Привсваеваем объектной переменной jsonArrayData список обьектов "Data" из Json файла
            JSONArray jsonArrayData = objectResponse.getJSONArray("data");
            //Создаем список dataList для хранения результата выполения цикла
            // (хранения всех обьектов списка Data)
            ArrayList<Data> dataList = new ArrayList<>();

            // Цикл перебора обьектов из списка "data"
            for (int i = 0; i < jsonArrayData.length(); i++) {
                //Обьектная переменная для перебора обьектов списка data по идексу [i]
                JSONObject objectData = jsonArrayData.getJSONObject(i);
                //Создаем Обьектную переменную класса data для хранения всех элементов
                Data data = new Data();
                // Вытягиваем из objectData обьект с именем id и присваеваем  его соответсвенной
                // переменной в Классе Data
                data.setId(objectData.getInt("id"));
                // Создаем Обьектную переменну objectFromCity для перебора обьектов from_city
                JSONObject objectFromCity = objectData.getJSONObject("from_city");
                // Создаем Обьектную переменную класа FromCity для хранения обьектов fromcity
                FromCity fromCity = new FromCity();
                // Вытягиваем из objectFromCity id, highlight, name и присваеваем  их соответсвенной
                // переменной в Классе FromCity
                fromCity.setHighlight(objectFromCity.getInt("highlight"));
                fromCity.setId(objectFromCity.getInt("id"));
                fromCity.setName(objectFromCity.getString("name"));
                // Передаем обьектную переменную класса fromCity в сообветствующую переменную класса
                // Data
                data.setFromCity(fromCity);
                data.setFrom_date(objectData.getString("from_date"));
                data.setFrom_time(objectData.getString("from_time"));
                data.setFrom_info(objectData.getString("from_info"));
                JSONObject objectToCity = objectData.getJSONObject("to_city");
                ToCity toCity = new ToCity();
                toCity.setHighlight(objectToCity.getInt("highlight"));
                toCity.setId(objectToCity.getInt("id"));
                toCity.setName(objectToCity.getString("name"));
                data.setToCity(toCity);
                data.setTo_date(objectData.getString("from_time"));
                data.setTo_time(objectData.getString("from_info"));
                data.setTo_info(objectData.getString("to_info"));
                data.setInfo(objectData.getString("info"));
                data.setPrice(objectData.getInt("price"));
                data.setBus_id(objectData.getInt("bus_id"));
                data.setReservation_count(objectData.getInt("reservation_count"));
                // Передаем в список dataList все обьекты из класса Data
                dataList.add(data);

            }
            //Передаем список обьектов dataList в соответствующую переменную Класа Response
            response.setDataLis(dataList);
            Log.d("CREATION", response.toString());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("", e.toString());
            return null;
        }
    }

}
