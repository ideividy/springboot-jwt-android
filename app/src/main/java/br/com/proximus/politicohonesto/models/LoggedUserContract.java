package br.com.proximus.politicohonesto.models;

import android.provider.BaseColumns;


/**
 * Contract class for constants for create DDL
 */
public final class LoggedUserContract {
    private LoggedUserContract(){

    }

    public static class LoggedUserEntry implements BaseColumns {
        public static final String TABLE_NAME = "logged_user";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_TOKEN = "token";
    }
}
