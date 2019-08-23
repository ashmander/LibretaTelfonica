package com.example.libretatelfonica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt;
    private EditText telEt;
    private Button addContactBtn;
    private ListView contactList;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = findViewById(R.id.contact_list);
        addContactBtn = findViewById(R.id.add_contact_btn);
        nameEt = findViewById(R.id.name_et);
        telEt = findViewById(R.id.tel_et);
        adapter = new ContactAdapter();
        contactList.setAdapter(adapter);
        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(nameEt.getText().toString(),telEt.getText().toString());
                adapter.addContact(contact);
            }
        });
    }
}
