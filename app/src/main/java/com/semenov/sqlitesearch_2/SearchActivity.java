package com.semenov.sqlitesearch_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;
    RecyclerView recyclerView;
    EditText editText;
/*    TextView textView;
    TextView textView2;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        databaseHandler = new DatabaseHandler(this);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText = (EditText) findViewById(R.id.editText);

/*        textView = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView4);*/

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(databaseHandler.getContact("Имя")); // add text from edittext

        MainAdapter mainAdapter = new MainAdapter(contacts); 
        recyclerView.setAdapter(mainAdapter);
    }
}