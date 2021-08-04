package com.semenov.sqlitesearch_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList <Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Имя", "номер"));
        contacts.add(new Contact("Имя", "номер"));
        contacts.add(new Contact("Имя", "номер"));
        contacts.add(new Contact("Имя", "номер"));

        MainAdapter mainAdapter = new MainAdapter(contacts);
        recyclerView.setAdapter(mainAdapter);
    }
}