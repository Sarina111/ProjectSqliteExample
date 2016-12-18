package com.example.sarina.projectexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sarina.projectexample.adapter.EmployeeRVAdapter;
import com.example.sarina.projectexample.db.DBManager;
import com.example.sarina.projectexample.modal.Employee;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    DBManager manager;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Employee List");
        mRecyclerView=(RecyclerView)findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(manager!=null){
            ArrayList<Employee> employees=manager.fetchEmployeeList();
            EmployeeRVAdapter mEmployeeRVAdapter=new EmployeeRVAdapter(this,employees);
            mRecyclerView.setAdapter(mEmployeeRVAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.menuAdd){
            Intent mIntent=new Intent(MainActivity.this,AddEmployeeActivity.class);
            startActivity(mIntent);

        }
        return super.onOptionsItemSelected(item);
    }
}
