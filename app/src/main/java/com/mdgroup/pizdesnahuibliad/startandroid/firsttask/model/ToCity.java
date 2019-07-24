package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model;

public class ToCity {
    // В Json файле существует обьект to_city в котором есть вложеные Обьекты
    // В этом классе инициализированы вложеные обьекты (id, name...) обьекта to_city
    // И описаны гетеры и сетеры к каждому обьету
    // сделано для парсера
    private int highlight;
    private int id;
    private String name;

    public int getHighlight() {
        return highlight;
    }

    public void setHighlight(int highlight) {
        this.highlight = highlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
