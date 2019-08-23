package com.example.libretatelfonica;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;

    public ContactAdapter () {
        contacts = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_contact, null);
        TextView rowNameTv = view.findViewById(R.id.row_name_tv);
        TextView rowTelTv = view.findViewById(R.id.row_tel_tv);
        Button deleteBtn = view.findViewById(R.id.delete_btn);
        Button callBtn = view.findViewById(R.id.call_btn);
        rowNameTv.setText(contacts.get(position).getName());
        rowTelTv.setText(contacts.get(position).getTelefono());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacts.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }
}
