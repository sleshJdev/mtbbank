package com.slesh.mtbbank.ui.main.fragment.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MainFragmentModule.class})
public interface MainFragmentComponent extends AndroidInjector<MainFragment> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainFragment> {
    }

}
