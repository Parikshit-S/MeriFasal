package com.example.android.merifasal;

import android.widget.EditText;

public class Seller {

    public String nameEt, shopNameEt, phoneEt, emailEt;

    public Seller(EditText nameEt, EditText shopNameEt, EditText phoneEt, EditText emailEt) {

    }

    public Seller(String nameEt, String shopNameEt, String phoneEt, String emailEt){
        this.nameEt =  nameEt;
        this.shopNameEt = shopNameEt;
        this.phoneEt = phoneEt;
        this.emailEt = emailEt;
    }
}
