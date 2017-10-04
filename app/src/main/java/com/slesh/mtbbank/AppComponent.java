package com.slesh.mtbbank;

import android.app.Application;

import com.slesh.mtbbank.ui.main.MainActivityComponent;
import com.slesh.mtbbank.ui.map.MapActivityComponent;
import com.slesh.mtbbank.ui.map.MapActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    public abstract class Builder extends AndroidInjector.Builder<App> {

        @BindsInstance
        public abstract Builder application(Application application);

        public abstract AppComponent build();

    }

}
