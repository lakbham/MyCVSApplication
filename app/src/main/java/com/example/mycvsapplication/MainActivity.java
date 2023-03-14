package com.example.mycvsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    private long pressedTime;
    ArrayList<String> ToDoListItems = new ArrayList<>();
    RecyclerView recyclerView;
    public Context ctx;
    RecyclerViewAdapter cvsAdapter;
    EditText input;
    Button add_button,Button3 ;
    ImageView imageView1,imageView2;
    private static final String TAG = "MainActivity";
    public static boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate(): called.");
        add_button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        cvsAdapter = new RecyclerViewAdapter(this, ToDoListItems, Button3, imageView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cvsAdapter);
        add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Add button Clicked:");
                input = findViewById((R.id.editText));
                String itemText = input.getText().toString();
                if (!(itemText.equals(" "))) {
                    ToDoListItems.add(itemText);
                    flag=true;
                    cvsAdapter.notifyDataSetChanged();
                    input.setText(" ");
                } else
                    Toast.makeText(getApplicationContext(), "Please enter some text...", Toast.LENGTH_LONG).show();

            }

        });
        cvsAdapter = new RecyclerViewAdapter(this, ToDoListItems, Button3, imageView2);
        Log.d(TAG, "adapter created");

        recyclerView.setAdapter((RecyclerView.Adapter) cvsAdapter);
        Log.d(TAG, "adapter attached");
    }
    // In the below code, when the user presses the ‘BACK’ button once, they are greeted with a toast asking them to press it again to exit.
    // If the user then presses ‘BACK’ again within 2 seconds(2000ms), then the app is closed, otherwise, we remain there.
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }


}




