package com.example.maverick;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    public SharedPref(Context context){
        this.context = context;
        pref = context.getSharedPreferences("",Context.MODE_PRIVATE);
        editor = pref.edit();



    }
    public void setLoggedIn(boolean logggedin){
        editor.putBoolean("loggedInmode", logggedin);
        editor.commit();
    }

    public boolean loggedIn(){
        return pref.getBoolean("loggedInmode", false);
    }

}
