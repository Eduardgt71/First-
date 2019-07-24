package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Data  {
    // Класс в котором инициализированы все обьекты списка Data из JSON
    // И описаны гетеры и сетеры к каждому обьету
    // файла. Для парсера

    private int id;

    private FromCity from_city;

    private String from_date;

    private String from_time;

    private String from_info;

    private ToCity to_city;

    private String to_date;

    private String to_time;

    private String to_info;

    private String info;

    private int price;

    private int bus_id;

    private int reservation_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FromCity getFromCity() {
        return from_city;
    }

    public void setFromCity(FromCity from_city) {
        this.from_city = from_city;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getFrom_time() {
        return from_time;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public String getFrom_info() {
        return from_info;
    }

    public void setFrom_info(String from_info) {
        this.from_info = from_info;
    }

    public ToCity getToCity() {
        return to_city;
    }

    public void setToCity(ToCity to_city) {
        this.to_city = to_city;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getTo_time() {
        return to_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public String getTo_info() {
        return to_info;
    }

    public void setTo_info(String to_info) {
        this.to_info = to_info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public int getReservation_count() {
        return reservation_count;
    }

    public void setReservation_count(int reservation_count) {
        this.reservation_count = reservation_count;
    }

}
