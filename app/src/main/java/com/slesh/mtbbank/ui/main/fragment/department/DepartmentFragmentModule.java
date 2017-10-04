package com.slesh.mtbbank.ui.main.fragment.department;

import dagger.Module;
import dagger.Provides;

@Module
public class DepartmentFragmentModule {

    @Provides
    public DepartmentFragmentContract.View view(DepartmentsFragment fragment) {
        return fragment;
    }

    @Provides
    public DepartmentFragmentContract.Presenter presenter(DepartmentPresenter rateInfoPresenter) {
        return rateInfoPresenter;
    }

    @Provides
    public DepartmentService myService() {
        return new DepartmentService();
    }

}
