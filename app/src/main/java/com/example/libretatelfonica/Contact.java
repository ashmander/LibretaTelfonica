package com.example.libretatelfonica;

import androidx.annotation.NonNull;

public class Contact {

    @NonNull
    private String name;
    private String telefono;

    public Contact() {
    }

    public Contact(String name, String telefono) {
        this.name = name;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
