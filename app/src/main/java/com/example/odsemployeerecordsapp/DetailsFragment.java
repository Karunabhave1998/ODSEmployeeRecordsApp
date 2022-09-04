package com.example.odsemployeerecordsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DetailsFragment extends Fragment {

    String employeeName;
    String employeeEmail;
    String employeeDesignation;
    String employeeMobile;
    String employeeDepartment;
    String employeeAddress;
    public DetailsFragment() {
        // Required empty public constructor
    }

    public DetailsFragment(String employeeName, String employeeEmail, String employeeDesignation, String employeeMobile, String employeeDepartment, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeDesignation = employeeDesignation;
        this.employeeMobile = employeeMobile;
        this.employeeDepartment = employeeDepartment;
        this.employeeAddress = employeeAddress;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_details, container, false);


        TextView firstname = v.findViewById(R.id.displayempName);
        TextView mail = v.findViewById(R.id.displayempEmail);
        TextView mobile = v.findViewById(R.id.displayempMobile);
        TextView department = v.findViewById(R.id.displayempDepartment);
        TextView designation = v.findViewById(R.id.displayempDesignation);
        TextView address = v.findViewById(R.id.displayempAddress);

        firstname.setText("FirstName: "+employeeName);
        mail.setText("Email: "+employeeEmail);
        mobile.setText("Mobile No: "+employeeMobile);
        department.setText("Department: "+employeeDepartment);
        designation.setText("Designation: "+employeeDesignation);
        address.setText("Address: "+employeeAddress);





        return v;
    }
}