package br.com.proximus.politicohonesto.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.proximus.politicohonesto.models.LoggedUserContract.LoggedUserEntry;

public class CreateLoggedUserRepository extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_LOGGED_USER =
            "CREATE TABLE " + LoggedUserEntry.TABLE_NAME + " ("+
             LoggedUserEntry._ID + " INTEGER PRIMARY KEY," +
             LoggedUserEntry.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
             LoggedUserEntry.COLUMN_NAME_TOKEN + TEXT_TYPE +")";

    private static final String SQL_DROP_LOGGED_USER = "DROP TABLE IF EXISTS " + LoggedUserEntry.TABLE_NAME;
    private static final int DATABASE_VERSAO = 1;
    private static final String DATABASE_NAME = "drp.db";


    public CreateLoggedUserRepository(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LOGGED_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_LOGGED_USER);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
