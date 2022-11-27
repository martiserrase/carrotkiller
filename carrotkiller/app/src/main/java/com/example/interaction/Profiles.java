package com.example.interaction;

public class Profiles {

    String name;
    String surname;
    String addInfo;

    public Profiles(String name, String surname, String addInfo) {
        this.name = name;
        this.surname = surname;
        this.addInfo = addInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
