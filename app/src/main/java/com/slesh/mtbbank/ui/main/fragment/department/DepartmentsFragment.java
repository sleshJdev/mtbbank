package com.slesh.mtbbank.ui.main.fragment.department;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.slesh.mtbbank.R;
import com.slesh.mtbbank.client.dto.Department;
import com.slesh.mtbbank.client.dto.RateInfo;
import com.slesh.mtbbank.ui.ext.AbstractTextWatcher;
import com.slesh.mtbbank.ui.main.fragment.department.adapter.CityAdapter;
import com.slesh.mtbbank.ui.main.fragment.department.adapter.DepartmentAdapter;
import com.slesh.mtbbank.ui.map.MapActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.DaggerFragment;

public class DepartmentsFragment extends DaggerFragment implements DepartmentFragmentContract.View {

    @Inject
    Context context;

    @Inject
    DepartmentFragmentContract.Presenter presenter;

    @Inject
    DepartmentService departmentService;

    @BindView(R.id.rate_info_list_view)
    ListView depsListView;

    @BindView(R.id.rate_info_search_textbox)
    EditText searchDepEditText;

    @BindView(R.id.department_city_spinner)
    Spinner depCitySpinner;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate_info, container, false);
    }

    @Override
    public void onViewCreated(View fragment, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(fragment, savedInstanceState);
        unbinder = ButterKnife.bind(this, fragment);
        searchDepEditText.addTextChangedListener(new AbstractTextWatcher() {
            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                presenter.filterDepartmentsByText(text);
            }
        });
        depsListView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(context, position, Toast.LENGTH_SHORT).show());
        depCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.filterDepartmentsByCityId((int) id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                presenter.resetCity();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.loadRatesInfo();
    }

    @Override
    public void displayData(RateInfo rateInfo) {
        displayDepartments(rateInfo.getDepartments());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayDepartments(List<Department> departments) {
        depsListView.setAdapter(new DepartmentAdapter(context, presenter, departments));
    }

    @Override
    public void fillInCities(List<String> cities) {
        depCitySpinner.setAdapter(new CityAdapter(context, cities));
    }

    @Override
    public void showAtMap(Department department) {
        Intent intent = new Intent(context, MapActivity.class)
                .putExtra(MapActivity.EXTRA_LON, department.getLongitude())
                .putExtra(MapActivity.EXTRA_LAT, department.getLatitude())
                .putExtra(MapActivity.EXTRA_TITLE, department.getLabel());
        startActivity(intent);
    }

    @Override
    public void showDepartmentsRates(Department department) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
