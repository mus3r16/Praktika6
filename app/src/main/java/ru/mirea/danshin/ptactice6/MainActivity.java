package ru.mirea.danshin.ptactice6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String PERSISTANT_STORAGE_NAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(PERSISTANT_STORAGE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = preferences.edit();

        ed.putString("NAME", "Alice");
        ed.putInt("AGE", 25);
        ed.putBoolean("SINGLE?", true);
        ed.apply();

        String name = preferences.getString("NAME", "unknown");
        int age = preferences.getInt("AGE", 0);
        boolean isSingle = preferences.getBoolean("SINGLE?", false);
    }
}