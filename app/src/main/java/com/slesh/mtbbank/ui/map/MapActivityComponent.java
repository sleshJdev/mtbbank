package com.slesh.mtbbank.ui.map;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MapActivityModule.class})
public interface MapActivityComponent extends AndroidInjector<MapActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MapActivity> {
    }

}
