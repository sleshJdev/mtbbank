package com.slesh.mtbbank.ui.main.fragment.department;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@Subcomponent(modules = {DepartmentFragmentModule.class})
public interface DepartmentFragmentComponent extends AndroidInjector<DepartmentsFragment> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DepartmentsFragment> {
    }

}
