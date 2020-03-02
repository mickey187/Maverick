package com.example.maverick;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences preferences;
    SharedPreferences.Editor editor ;
    Context context;
    public static void save(Context context,String name, String value){

       SharedPreferences preferences = context.getSharedPreferences("",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name,value);
        editor.apply();



    }
  public static String read(Context context,String name,String defaultValue){
        SharedPreferences preferences = context.getSharedPreferences("clipcodes",Context.MODE_PRIVATE);
return preferences.getString(name,defaultValue);
  }

}
