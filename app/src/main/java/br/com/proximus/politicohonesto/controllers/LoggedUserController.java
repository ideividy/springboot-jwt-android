package br.com.proximus.politicohonesto.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import br.com.proximus.politicohonesto.models.LoggedUserContract;
import br.com.proximus.politicohonesto.repositories.CreateLoggedUserRepository;

public class LoggedUserController {

    private SQLiteDatabase db;
    private CreateLoggedUserRepository loggedUserRepository;

    public LoggedUserController (Context context) {
        loggedUserRepository = new CreateLoggedUserRepository(context);
    }

    public String insertLogin(String email, String token){
        ContentValues values;
        long result;

        db = loggedUserRepository.getWritableDatabase();
        values = new ContentValues();
        values.put(LoggedUserContract.LoggedUserEntry.COLUMN_NAME_EMAIL, email);
        values.put(LoggedUserContract.LoggedUserEntry.COLUMN_NAME_TOKEN, token);

        result = db.insert(LoggedUserContract.LoggedUserEntry.TABLE_NAME, null, values);
        db.close();

        return result == -1 ? "Error to insert" : "Sucess";
    }

    public String getTokenByEmail(String email) {
        //SQLiteDatabase db = loggedUserRepository.getReadableDatabase();

        String query = "SELECT  * FROM " + LoggedUserContract.LoggedUserEntry.TABLE_NAME;
        SQLiteDatabase db = loggedUserRepository.getWritableDatabase();

        //Cursor cursor = db.rawQuery(query, null);

        Cursor cursor = db.query(LoggedUserContract.LoggedUserEntry.TABLE_NAME, // a. table
                LoggedUserContract.LoggedUserEntry.COLUMNS, // b. column names
                LoggedUserContract.LoggedUserEntry.COLUMN_NAME_EMAIL + " = ?", // c. selections
                new String[] { String.valueOf(email) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        String token = "";

        List list = new ArrayList();
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                token = cursor.getString(cursor.getColumnIndex(LoggedUserContract.LoggedUserEntry.COLUMN_NAME_TOKEN));
                list.add(token);
                cursor.moveToNext();

            }

        }

        return token;
    }

}
