package com.example.odsemployeerecordsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {


    ListView empListview;
    EmpListModel empListModel;
    EmpListAdapter empListAdapter;

    List<EmpListModel> empListModelList = new ArrayList<>();

    SQLiteDatabase db1;
    EmployeesHelperClass employeesHelperClass;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        empListview=root.findViewById(R.id.employeeListId);

        employeesHelperClass=new EmployeesHelperClass(getContext());
        db1=employeesHelperClass.getReadableDatabase();
        Toast.makeText(getContext(), "List Selected", Toast.LENGTH_SHORT).show();

        empListAdapter=new EmpListAdapter(getContext(),empListModelList);
        empListview.setAdapter(empListAdapter);

        readData();
//        empListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//                Intent intent=new Intent(getContext(),MainActivity2.class);
//                intent.putExtra("countrieskey",userpojoList.get(i).getCountries());
//                intent.putExtra("capitalkey",userpojoList.get(i).getCapital());
//                intent.putExtra("imagekey",userpojoList.get(i).getImage());
//                startActivity(intent);
//            }
//        });

        empListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,new DetailsFragment(empListModelList.get(i).getEmployeeName(),empListModelList.get(i).getEmployeeEmail(),empListModelList.get(i).getEmployeeDesignation(),empListModelList.get(i).getEmployeeMobile(),empListModelList.get(i).getEmployeeDepartment(),empListModelList.get(i).getEmployeeAddress())).addToBackStack(null).commit();









            }
        });



        return root;
    }

    private void readData() {

        empListModelList.clear();

        String[] col = {"Id","Ename","Email","Emobile","Edepartment","Edesignation","Eaddress"};
        Cursor cursor=db1.query("ODSEmployeeRecordTable1",col,null,null,null,null,null);

        if(cursor.getCount()>0&&cursor!=null)
        {
            while (cursor.moveToNext())
            {
                String empName1 = cursor.getString(1);
                String empMail1 = cursor.getString(2);
                String empDesignation1 = cursor.getString(5);
                String empMobile1 = cursor.getString(3);
                String empDepartment1 = cursor.getString(4);
                String empAddress1 = cursor.getString(6);

                empListModel = new EmpListModel("Name:"+empName1,"\nEmail:"+empMail1,"\nDesignation:"+empDesignation1,empMobile1,empDepartment1,empAddress1);
                empListModelList.add(empListModel);
                empListAdapter.notifyDataSetChanged();


            }

        }
        else {
            Toast.makeText(getContext(),"No Record found",Toast.LENGTH_SHORT).show();
        }





    }





}