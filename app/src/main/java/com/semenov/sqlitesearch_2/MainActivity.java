package com.semenov.sqlitesearch_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    DatabaseHandler databaseHandler;
    Button btnRead;

    EditText etName, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button) findViewById(R.id.button);
        btnRead.setOnClickListener(this);

/*        etName = (EditText) findViewById(R.id.etName);
        etPhoneNumber = (EditText) findViewById(R.id.etEmail);*/

        databaseHandler = new DatabaseHandler(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHandler.addContact(new Contact("Имя", "номер"));
        databaseHandler.addContact(new Contact("Имя2", "номер2"));
        databaseHandler.addContact(new Contact("Имя3", "номер3"));
        databaseHandler.addContact(new Contact("Имя4", "номер4"));

        ArrayList <Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Имя", "номер"));
        contacts.add(new Contact("Имя2", "номер2"));
        contacts.add(new Contact("Имя3", "номер3"));
        contacts.add(new Contact("Имя4", "номер4"));

        MainAdapter mainAdapter = new MainAdapter(contacts);
        recyclerView.setAdapter(mainAdapter);
    }


    @Override
    public void onClick(View view) {

/*        String name = etName.getText().toString();
        String email = etPhoneNumber.getText().toString();*/

        SQLiteDatabase database = databaseHandler.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (view.getId()) {
            case R.id.button:
            Cursor cursor = database.query(DatabaseHandler.TABLE_CONTACTS, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DatabaseHandler.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DatabaseHandler.KEY_NAME);
                int emailIndex = cursor.getColumnIndex(DatabaseHandler.KEY_PH_NUM);
                do {
                    Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                            ", name = " + cursor.getString(nameIndex) +
                            ", email = " + cursor.getString(emailIndex));
                } while (cursor.moveToNext());
            } else
                Log.d("mLog","0 rows");

            cursor.close();
        }

    }
}