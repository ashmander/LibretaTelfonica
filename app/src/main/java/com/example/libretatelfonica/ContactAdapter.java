package com.example.libretatelfonica;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;
    Context context;

    public ContactAdapter (MainActivity mainActivity) {
        contacts = new ArrayList<>();
        context = mainActivity;
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
        final TextView rowTelTv = view.findViewById(R.id.row_tel_tv);
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
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = rowTelTv.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                try {
                    context.startActivity(intent);
                }catch (SecurityException e) {

                }
            }
        });
        return view;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }

    public Intent callNumber(){
        Intent intent = null;

        return intent;
    }
}
