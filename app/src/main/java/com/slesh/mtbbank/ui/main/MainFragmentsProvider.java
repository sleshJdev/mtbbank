package com.slesh.mtbbank.ui.main;

import android.app.Fragment;

import com.slesh.mtbbank.ui.main.fragment.department.DepartmentFragmentComponent;
import com.slesh.mtbbank.ui.main.fragment.department.DepartmentsFragment;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragment;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by yauheni on 10/4/17.
 */

@Module
public abstract class MainFragmentsProvider {

    @Binds
    @IntoMap
    @FragmentKey(DepartmentsFragment.class)
    public abstract AndroidInjector.Factory<? extends Fragment> bindDepartmentsFragment(DepartmentFragmentComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(MainFragment.class)
    public abstract AndroidInjector.Factory<? extends Fragment> bindMainFragment(MainFragmentComponent.Builder builder);

}
