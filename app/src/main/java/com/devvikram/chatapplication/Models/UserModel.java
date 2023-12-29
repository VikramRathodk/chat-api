package com.devvikram.chatapplication.Models;

public class UserModel {

    String id;
    int img;
    String name,number;


    public UserModel(String id, String name, int img, String number) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
