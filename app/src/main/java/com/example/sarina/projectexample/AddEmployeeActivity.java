package com.example.sarina.projectexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sarina.projectexample.db.DBManager;

/**
 * Created by Sarina on 12/18/2016.
 */

public class AddEmployeeActivity extends BaseActivity implements View.OnClickListener {
    EditText etName;
    EditText etAddress;
    EditText etPhone;
    Button btnSave;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        init();
    }

    private void init(){
        etName=(EditText)findViewById(R.id.etName);
        etAddress=(EditText)findViewById(R.id.etAddress);
        etPhone=(EditText)findViewById(R.id.etPhone);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(isFromValid()){
            String name=etName.getText().toString();
            String address=etAddress.getText().toString();
            String phone=etPhone.getText().toString();
            manager.insertEmployee(name,address,phone);
            finish();
        }

    }


    private boolean isFromValid(){
        if(etName.getText().toString().trim().length()<1){
            etName.setError("Name can't be empty");
            return false;
        }
        if(etAddress.getText().toString().trim().length()<1){
            etAddress.setError("Address can't be empty");
            return false;
        }
        if(etPhone.getText().toString().trim().length()<1){
            etPhone.setError("Phone can't be empty");
            return false;
        }

        return true;

    }
}
