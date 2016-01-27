package com.carlosjacinto.vainness;

import android.content.Context;

import java.util.List;

/**
 * Created by apptizer on 27/01/2016.
 */
public class DatabaseWritter {

    public DatabaseWritter(Context context) {
        DatabaseHandler db = new DatabaseHandler(context);
        List<ItemHandler> itemHandlers = db.getAllItems();
        List<HeroesHandler> heroesHandlers = db.getAllHeros();

        WriteDB(context);

    }

    public void WriteDB(Context context) {
        DatabaseHandler db = new DatabaseHandler(context);
        db.addItem(new ItemHandler("Crutial"));
    }

}

