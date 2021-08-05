package com.semenov.sqlitesearch_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler databaseHandler;
    RecyclerView recyclerView;
    EditText editText;
    Button button;
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

        button = (Button) findViewById(R.id.buttonSearch);
        button.setOnClickListener(this);

/*        textView = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView4);*/
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
                Log.d("mLog","onClick");
        String name = editText.getText().toString();
        switch (view.getId()){

            case R.id.buttonSearch:
                ArrayList<Contact> contacts = new ArrayList<>();
                contacts.add(databaseHandler.getContact(name));

                MainAdapter mainAdapter = new MainAdapter(contacts);
                recyclerView.setAdapter(mainAdapter);
                Log.d("mLog","onClick_2");
                break;
        }
    }
}