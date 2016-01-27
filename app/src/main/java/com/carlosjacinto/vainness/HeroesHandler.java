package com.carlosjacinto.vainness;

/**
 * Created by apptizer on 27/01/2016.
 */
public class HeroesHandler {

    //variaveis privadas
    int _id;
    String _hero_name;
    String _hero_desc;


    // constructor vazio
    public HeroesHandler(){
    }
    // constructor
    public HeroesHandler(int id, String hero_name, String hero_desc){
        this._id = id;
        this._hero_name = hero_name;
        this._hero_desc = hero_desc;

    }
    // constructor
    public HeroesHandler(String hero_name){
        this._hero_name = hero_name;

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
    public String getHeroName(){
        return this._hero_name;
    }
    // setting name
    public void setHeroName(String hero_name){
        this._hero_name = hero_name;
    }

    public String getDescription(){
        return this._hero_desc;
    }
    // setting description

    public void setDescription(String hero_desc){
        this._hero_desc = hero_desc;
    }

}