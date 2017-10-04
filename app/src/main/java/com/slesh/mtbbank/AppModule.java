package com.slesh.mtbbank;

import android.app.Application;
import android.content.Context;

import com.slesh.mtbbank.client.api.MtbClient;
import com.slesh.mtbbank.ui.main.MainActivityComponent;
import com.slesh.mtbbank.ui.map.MapActivityComponent;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module(subcomponents = {
        MainActivityComponent.class,
        MapActivityComponent.class
})
public class AppModule {

    private static final String MTBANK_API_URL = "https://www.mtbank.by";

    @Provides
    public Context context(Application application) {
        return application;
    }

    @Provides
    public Retrofit xmlHttpAdapter() {
        return new Retrofit.Builder()
                .baseUrl(MTBANK_API_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    public MtbClient mtbClient(Retrofit retrofit) {
        return retrofit.create(MtbClient.class);
    }

}
