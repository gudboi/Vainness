package com.carlosjacinto.vainness;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class VainDBLogTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        db.addItem(new ItemHandler("crutial", "ability"));
        Log.d("Reading: ", "Reading all items..");
        List<ItemHandler> itemHandlers = db.getAllItems();
        for (ItemHandler cn : itemHandlers) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getItemName() + " ,Category: " + cn.getCategory();
            Log.d("Name: ", log);
        }
    }
}