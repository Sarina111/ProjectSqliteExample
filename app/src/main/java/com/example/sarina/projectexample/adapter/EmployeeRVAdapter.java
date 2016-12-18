package com.example.sarina.projectexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarina.projectexample.R;
import com.example.sarina.projectexample.modal.Employee;

import java.util.ArrayList;


/**
 * Created by Sarina on 12/18/2016.
 */

public class EmployeeRVAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    Context mContext;
    ArrayList<Employee> employees;

    public EmployeeRVAdapter(Context mContext, ArrayList<Employee>employees){
        this.mContext=mContext;
        this.employees=employees;

    }
    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(mContext).inflate(R.layout.employee_item,null);

        return new EmployeeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        Employee mEmployee=employees.get(position);
        holder.txtAddress.setText(mEmployee.getAddress());
        holder.txtPhone.setText(mEmployee.getPhone()+"");
        holder.txtName.setText(mEmployee.getName());


    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
