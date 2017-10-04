package com.slesh.mtbbank.ui.main.fragment.department.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.slesh.mtbbank.databinding.DepartmentCitySpinnerItemBinding;

import java.util.List;

public class CityAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<String> cities;

    public CityAdapter(@NonNull Context context, @NonNull List<String> cities) {
        layoutInflater = LayoutInflater.from(context);
        this.cities = cities;
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public String getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            DepartmentCitySpinnerItemBinding binding = DepartmentCitySpinnerItemBinding.inflate(layoutInflater, parent, false);
            binding.setCityTitle(getItem(position));
            return binding.getRoot();
        }
        return convertView;
    }
}
