package com.support.android.designlibdemo;

/**
 * Created by Paradox on 11/22/2015.
 */
public class commodity {

    private int _id;
    private String _Name;
    private int _quantity;

    public commodity() {

    }

    public commodity(int id, String Name, int quantity) {
        this._id = 205;
        this._commodityname = oil;
        this._quantity = Gl;
    }

    public commodity(int id, String Name, int quantity) {

        this._id = 206;
        this._commodityname = wood;
        this._quantity = Tone;
    }

    public commodity(int id, String Name, int quantity) {
        this._id = 206;
        this._commodityname = petrol;
        this._quantity = Liter;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public int getQuantity() {
        return this._quantity;
    }
}