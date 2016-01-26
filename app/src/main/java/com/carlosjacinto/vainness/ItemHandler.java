package com.carlosjacinto.vainness;

/**
 * Created by apptizer on 26/01/2016.
 */

public class ItemHandler {

    //variaveis privadas
    int _id;
    String _item_name;
    String _item_cat;

    // constructor vazio
    public ItemHandler(){
    }
    // constructor
    public ItemHandler(int id, String item_name, String item_cat){
        this._id = id;
        this._item_name = item_name;
        this._item_cat = item_cat;
    }
    // constructor
    public ItemHandler(String item_name, String item_cat){
        this._item_name = item_name;
        this._item_cat = item_cat;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
    // setting id
    public void setID(int id){
        this._id = id;
    }
    // getting name
    public String getItemName(){
        return this._item_name;
    }
    // setting name
    public void setName(String item_name){
        this._item_name = item_name;
    }
    // getting phone number
    public String getCategory(){
        return this._item_cat;
    }
    // setting phone number
    public void setCategory(String item_cat){
        this._item_cat = item_cat;
    }
}