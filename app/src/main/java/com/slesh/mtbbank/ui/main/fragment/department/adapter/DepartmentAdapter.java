package com.slesh.mtbbank.ui.main.fragment.department.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.slesh.mtbbank.client.dto.Department;
import com.slesh.mtbbank.databinding.DepartmentListViewRowBinding;
import com.slesh.mtbbank.ui.main.fragment.department.DepartmentFragmentContract;

import java.util.List;

public class DepartmentAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final DepartmentFragmentContract.Presenter presenter;
    private final List<Department> departments;

    public DepartmentAdapter(@NonNull Context context,
                             @NonNull DepartmentFragmentContract.Presenter presenter,
                             @NonNull List<Department> departments) {
        this.layoutInflater = LayoutInflater.from(context);
        this.presenter = presenter;
        this.departments = departments;
    }

    @Override
    public int getCount() {
        return departments.size();
    }

    @Override
    public Object getItem(int position) {
        return departments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            DepartmentListViewRowBinding binding = DepartmentListViewRowBinding.inflate(layoutInflater, parent, false);
            binding.setDepartment((Department) getItem(position));
            binding.setPresenter(presenter);
            return binding.getRoot();
        }
        return convertView;
    }

}
