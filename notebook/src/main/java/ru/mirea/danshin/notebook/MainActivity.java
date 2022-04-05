package ru.mirea.danshin.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String fileName;

    private EditText text;
    private EditText name;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textName);
        text = findViewById(R.id.text);
        preferences = getPreferences(MODE_PRIVATE);

        FileOutputStream outputStream;
        try {
            fileName = name + ".txt";
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(text.getText().toString().getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCklick(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_TEXT, text.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show(); }
}