package com.example.maverick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "master.db";
    private static final int DATABASE_VERSION = 1;
    public static final  String TABLE_NAME = "users";
    public static final  String COLUMN_ID = "ID";
    public static final  String COLUMN_FULLNAME = "fullname";
    public static final  String COLUMN_USERNAME = "username";
    public static final  String COLUMN_SEX = "sex";
    public static final  String COLUMN_EMAIL = "email";
    public static final  String COLUMN_PASSWORD = "password";
    public static final  String COLUMN_PHONE = "phone";




    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert(TABLE_NAME,"",contentValues);
    }
    public boolean isLoginValid(String email, String password){
        String sql = "select count(*) from "+ TABLE_NAME +" where email='" + email +"' and password='" + password +"'";
        SQLiteStatement sqLiteStatement = getReadableDatabase().compileStatement(sql);
        long l = sqLiteStatement.simpleQueryForLong();
        sqLiteStatement.close();
        if(l == 1){
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_MASTER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER NOT NULL CONSTRAINT users_pk PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FULLNAME + " varchar(200)NOT NULL, " +
                COLUMN_USERNAME + " varchar(200)NOT NULL, " +
                COLUMN_SEX + " varchar(15) NOT NULL, " +
                COLUMN_EMAIL + " varchar(200) NOT NULL, " +
                COLUMN_PASSWORD + " varchar(200) NOT NULL, " +
                COLUMN_PHONE + " INTEGER NOT NULL " +

                ");";
        db.execSQL(SQL_CREATE_MASTER_TABLE);



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);


    }


    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_NAME ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.getCount()>0){
            //  cursor.moveToFirst();
            while(cursor.moveToNext()){
                User u=new User();
                u.setFullname(cursor.getString(1));
                u.setUsername(cursor.getString(2));
                u.setSex(cursor.getString(3));
                u.setEmail(cursor.getString(4));
                u.setPhone(cursor.getString(5));
                users.add(u);
            }
            cursor.close();

        }

        return users;
    }
}
