package com.slesh.mtbbank.ui.map;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MapActivityModule {

    @Provides
    MapService mapService() {
        return new MapService();
    }

}
