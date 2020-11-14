package com.example.supermerkapp;

public class ListElement {

    // public ImageView imgP;
    public String nameP;
    public String precioP;

    public ListElement(String nameP, String precioP) {
        this.nameP = nameP;
        this.precioP = precioP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getPrecioP() {
        return precioP;
    }

    public void setPrecioP(String precioP) {
        this.precioP = precioP;
    }
}


