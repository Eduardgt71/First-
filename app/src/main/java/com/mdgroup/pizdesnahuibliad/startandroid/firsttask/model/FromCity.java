package com.mdgroup.pizdesnahuibliad.startandroid.firsttask.model;

public class FromCity {
    // В Json файле существует обьект from_city в котором есть вложеные Обьекты
    // В этом классе инициализированы вложеные обьекты (id, name...) обьекта from_city
    // И описаны гетеры и сетеры к каждому обьету
    //Сделано для парсера

    private int highlight;
    private int id;
    private String name;

    public Integer getHighlight() {
        return highlight;
    }

    public void setHighlight(int highlight) {
        this.highlight = highlight;
    }

    public Integer getId() {
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
