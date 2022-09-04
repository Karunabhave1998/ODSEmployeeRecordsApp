package com.example.odsemployeerecordsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EmpListAdapter extends BaseAdapter {

    Context context;
    List<EmpListModel> empListModelList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public EmpListAdapter(Context context, List<EmpListModel> empListModelList) {
        this.context = context;
        this.empListModelList = empListModelList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return empListModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        View root=layoutInflater.inflate(R.layout.custom_emp_layout,null);

        TextView listEmpName1 = root.findViewById(R.id.listEmpNameId);
        TextView listEmpEmail1 = root.findViewById(R.id.listEmpEmailId);
        TextView  listEmpDesignationId1 = root.findViewById(R.id.listEmpDesignationId);

        listEmpName1.setText(empListModelList.get(i).getEmployeeName());
        listEmpEmail1.setText(empListModelList.get(i).getEmployeeEmail());
        listEmpDesignationId1.setText(empListModelList.get(i).getEmployeeDesignation());

        return root;
    }
}
