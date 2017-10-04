package com.slesh.mtbbank;

import android.app.Activity;
import android.app.Fragment;

import com.slesh.mtbbank.ui.main.MainActivity;
import com.slesh.mtbbank.ui.main.MainActivityComponent;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragment;
import com.slesh.mtbbank.ui.main.fragment.main.MainFragmentComponent;
import com.slesh.mtbbank.ui.map.MapActivity;
import com.slesh.mtbbank.ui.map.MapActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MapActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindMapActivity(MapActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

}
