package com.carlosjacinto.vainness;

/**
 * Created by apptizer on 26/01/2016.
 */

public class ItemHandler {

    //variaveis privadas
    int _id;
    String _item_name;
    String _item_cat;
    String _item_desc;

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

    public ItemHandler(String item_name){
        this._item_name = item_name;

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
    // getting category
    public String getCategory(){
        return this._item_cat;
    }
    // setting category
    public void setCategory(String item_cat){
        this._item_cat = item_cat;
    }

    public String getDescription(){
        return this._item_desc;
    }
    // setting description
    public void setDescription(String item_desc){
        this._item_desc = item_desc;
    }
}