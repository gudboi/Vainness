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
    private static final String KEY_ID = "item_id";
    private static final String KEY_NAME = "item_name";
    private static final String KEY_CAT = "item_cat";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_CAT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }
    public void addItem(ItemHandler itemHandler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, itemHandler.getItemName()); // Name
        values.put(KEY_CAT, itemHandler.getCategory()); // Item Category
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }
    public ItemHandler getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_ID,
                        KEY_NAME, KEY_CAT }, KEY_ID + "=?",
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
                itemList.add(itemHandler);
            } while (cursor.moveToNext());
        }
        return itemList;
    }
    public int updateContact(ItemHandler itemHandler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, itemHandler.getItemName());
        values.put(KEY_CAT, itemHandler.getCategory());
        return db.update(TABLE_ITEMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(itemHandler.getID()) });
    }
    public void deleteItem(ItemHandler contact) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
    public int getItemsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}