package com.slesh.mtbbank.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.slesh.mtbbank.R;
import com.slesh.mtbbank.data.AppRepository;
import com.slesh.mtbbank.ui.main.fragment.department.DepartmentsFragment;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragment;
import com.slesh.mtbbank.ui.map.MapService;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

public class MainActivity extends DaggerActivity implements MainActivityContract.View, MainFragment.OnClickListener {

    @Inject
    MainPresenter mainPresenter;

    @Inject
    AppRepository appRepository;

    @Inject
    MainService mapService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.main_fragment_container, new MainFragment())
                .commit();
    }

    @Override
    public void onDepartmensClick() {
        getFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, new DepartmentsFragment())
                .commit();
    }

}
