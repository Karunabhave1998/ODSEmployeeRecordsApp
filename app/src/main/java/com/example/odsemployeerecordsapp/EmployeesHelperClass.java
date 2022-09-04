package com.example.odsemployeerecordsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EmployeesHelperClass extends SQLiteOpenHelper {

    Context context;

    public EmployeesHelperClass(@Nullable Context context) {
        super(context, "ODSEmployeeDetails.db",null,2);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create Table ODSEmployeeRecordTable1(Id Integer primary key AUTOINCREMENT,Ename text,Email text,Emobile text,Edepartment text,Edesignation text,Eaddress text)");//Eimage BLOB
        Toast.makeText(context, "SQL started", Toast.LENGTH_SHORT).show();

    }

    public long createMethod(SQLiteDatabase db,int eid,String ename,String email,String emobile,String edepartment,String edesignation,String eaddress)    //byte[] eimage
    {



        ContentValues cv=new ContentValues();

        cv.put("Id",eid);
        cv.put("EName",ename);
        cv.put("EMail",email);
        cv.put("EMobile",emobile);
        cv.put("EDepartment",edepartment);
        cv.put("EDesignation",edesignation);
        cv.put("EAddress",eaddress);
        //cv.put("Eimage",eimage);

        long set=db.insert("ODSEmployeeRecordTable1",null,cv);
        return set;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        if(i<i1)
        {
             db.execSQL("Alter Table ODSEmployeeRecordTable1 ADD Mobile Text ");
            db.execSQL("Alter Table ODSEmployeeRecordTable1 ADD Address Text ");
        }

    }
}
