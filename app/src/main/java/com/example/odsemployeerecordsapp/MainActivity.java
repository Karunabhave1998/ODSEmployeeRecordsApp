package com.example.odsemployeerecordsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    TextInputEditText eidEdt, enameEdt, emailEdt, emobileEdt, edepartmentEdt, edesignationEdt, eaddressEdt;
    ImageView eimageView;
    ImageView historyImage;

    Button submitBtn;
    EmployeesHelperClass employeesHelperClass;
    SQLiteDatabase db;

    int value;
    String enameStr,emailStr,emobileStr,edepartmentStr,edesignationStr,eaddressStr;



    Button BSelectImage;
    ImageView IVPreviewImage;

    int SELECT_PICTURE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        eidEdt = findViewById(R.id.empId);
        enameEdt = findViewById(R.id.empFnameID);
        emailEdt = findViewById(R.id.empEmail);
        emobileEdt = findViewById(R.id.empMob);
        edepartmentEdt = findViewById(R.id.empDepartment);
        edesignationEdt = findViewById(R.id.empDesignation);
        eaddressEdt = findViewById(R.id.empAddress);
        historyImage = findViewById(R.id.historyId);

        submitBtn = findViewById(R.id.submitbtn);

        eimageView = findViewById(R.id.IVPreviewImage);

        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);

        employeesHelperClass=new EmployeesHelperClass(this);
        db=employeesHelperClass.getReadableDatabase();



        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value= Integer.parseInt(eidEdt.getText().toString().trim());
                enameStr=enameEdt.getText().toString().trim();
                emailStr=emailEdt.getText().toString().trim();
                emobileStr=emobileEdt.getText().toString().trim();
                edepartmentStr=edepartmentEdt.getText().toString().trim();
                edesignationStr=edesignationEdt.getText().toString().trim();
                eaddressStr=eaddressEdt.getText().toString().trim();

//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),200);
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//                byte[] img = byteArrayOutputStream.toByteArray();






                if(enameStr.length()==0)
                {
                    enameEdt.setError("Enter name");
                }
                else if(emailStr.length()==0)
                {
                    emailEdt.setError("enter mail");
                }
                else if(emobileStr.length()==0)
                {
                    emobileEdt.setError("enter mail");
                }
                else if(edepartmentStr.length()==0)
                {
                    edepartmentEdt.setError("enter mail");
                }
                else if(edesignationStr.length()==0)
                {
                    edesignationEdt.setError("enter mail");
                }
                else if(eaddressStr.length()==0)
                {
                    eaddressEdt.setError("enter mail");
                }



                long set=employeesHelperClass.createMethod(db,value,enameStr,emailStr,emobileStr,edepartmentStr,edesignationStr,eaddressStr);

                if (set == -1)
                {
                    Toast.makeText(MainActivity.this, "Record Already Exist", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "New Record Created Successfully", Toast.LENGTH_SHORT).show();
                }






            }
        });

        historyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EmployeeDetailsActivity.class);
                startActivity(intent);
            }
        });

    }


    public void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
}