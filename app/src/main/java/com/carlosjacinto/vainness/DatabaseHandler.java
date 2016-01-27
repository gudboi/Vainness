package com.carlosjacinto.vainness;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Nome da Base de Dados
    private static final String DATABASE_NAME = "vain.db";
    private static final String TABLE_ITEMS = "items";
    private static final String KEY_ITEM_ID = "item_id";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_ITEM_DESC = "item_desc";
    private static final String KEY_ITEM_CAT = "item_cat";

    private static final String TABLE_HEROES = "heroes";
    private static final String KEY_HERO_ID = "hero_id";
    private static final String KEY_HERO_NAME = "hero_name";
    private static final String KEY_HERO_DESC = "hero_desc";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ITEM_ID + " INTEGER PRIMARY KEY," + KEY_ITEM_NAME + " TEXT,"
                + KEY_ITEM_CAT + " TEXT" + KEY_ITEM_DESC + " TEXT" + ")";
        db.execSQL(CREATE_ITEMS_TABLE);

        String CREATE_HEROES_TABLE = "CREATE TABLE " + TABLE_HEROES + "("
                + KEY_HERO_ID + " INTEGER PRIMARY KEY," + KEY_HERO_NAME + " TEXT" + KEY_HERO_DESC + " TEXT" +
                ")";
        db.execSQL(CREATE_HEROES_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HEROES);
        onCreate(db);
    }
    public void addItem(ItemHandler itemHandler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ITEM_NAME, itemHandler.getItemName()); // Name
        values.put(KEY_ITEM_CAT, itemHandler.getCategory()); // Item Category
        values.put(KEY_ITEM_DESC, itemHandler.getDescription()); // Item Description

        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }
    public void addHero(ItemHandler itemHandler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HERO_NAME, itemHandler.getItemName()); // Name
        db.insert(TABLE_HEROES, null, values);
        db.close();
    }
    public ItemHandler getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_ITEM_ID,
                        KEY_ITEM_NAME, KEY_ITEM_CAT }, KEY_ITEM_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        ItemHandler itemHandler = new ItemHandler(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return itemHandler;
    }

    public List<ItemHandler> getAllItems() {
        List<ItemHandler> itemList = new ArrayList<ItemHandler>();
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ItemHandler itemHandler = new ItemHandler();
                itemHandler.setID(Integer.parseInt(cursor.getString(0)));
                itemHandler.setName(cursor.getString(1));
                itemHandler.setCategory(cursor.getString(2));
                itemHandler.setDescription(cursor.getString(3));
                itemList.add(itemHandler);
            } while (cursor.moveToNext());
        }
        return itemList;
    }


    public List<HeroesHandler> getAllHeros() {
        List<HeroesHandler> heroesList = new ArrayList<HeroesHandler>();
        String selectQuery = "SELECT  * FROM " + TABLE_HEROES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HeroesHandler heroesHandler = new HeroesHandler();
                heroesHandler.setID(Integer.parseInt(cursor.getString(0)));
                heroesHandler.setHeroName(cursor.getString(1));
                heroesHandler.setDescription(cursor.getString(2));
                heroesList.add(heroesHandler);
            } while (cursor.moveToNext());
        }
        return heroesList;
    }

    public int getItemsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}