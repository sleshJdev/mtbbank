package com.slesh.mtbbank.ui.main;

import android.app.Activity;
import android.app.Fragment;

import com.slesh.mtbbank.ui.main.fragment.department.DepartmentsFragment;
import com.slesh.mtbbank.ui.main.fragment.department.DepartmentFragmentComponent;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragment;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragmentComponent;
import com.slesh.mtbbank.ui.map.MapService;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DepartmentFragmentComponent.class, MainFragmentComponent.class})
public abstract class MainActivityModule {

    @Provides
    public static MainService mapService() {
        return new MainService();
    }

}
