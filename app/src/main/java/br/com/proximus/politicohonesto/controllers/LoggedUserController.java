package br.com.proximus.politicohonesto.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
