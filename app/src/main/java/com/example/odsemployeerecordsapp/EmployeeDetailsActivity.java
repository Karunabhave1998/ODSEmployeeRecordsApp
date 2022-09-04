package com.example.odsemployeerecordsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class EmployeeDetailsActivity extends AppCompatActivity {

//    ListFragment listFragment1 = new ListFragment();
//    DetailsFragment detailsFragment1 = new DetailsFragment();
//    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




//        FragmentManager fm = getFragmentManager();
//        fm.beginTransaction().replace(R.id.fragment1,listFragment1,"FragmentOne").commit();
//        fm.beginTransaction().replace(R.id.fragment2, detailsFragment1, "FragmentTwo").commit();
    }
}