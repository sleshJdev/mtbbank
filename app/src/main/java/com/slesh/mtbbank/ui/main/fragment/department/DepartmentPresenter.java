package com.slesh.mtbbank.ui.main.fragment.department;

import android.support.annotation.NonNull;
import android.util.Log;

import com.slesh.mtbbank.client.api.MtbClient;
import com.slesh.mtbbank.client.dto.Department;
import com.slesh.mtbbank.client.dto.RateInfo;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import java8.util.function.Predicate;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentPresenter implements DepartmentFragmentContract.Presenter {

    private final DepartmentFragmentContract.View view;
    private final MtbClient mtbApi;

    private List<String> cities;
    private RateInfo rateInfo;
    private String searchText;

    @Inject
    public DepartmentPresenter(DepartmentFragmentContract.View view,
                               MtbClient mtbClient) {
        this.view = view;
        this.mtbApi = mtbClient;
    }

    @Override
    public void loadRatesInfo() {
        mtbApi.fetchLastRateInfo()
                .enqueue(new Callback<RateInfo>() {
                    @Override
                    public void onResponse(@NonNull Call<RateInfo> call, @NonNull Response<RateInfo> response) {
                        rateInfo = response.body();
                        cities = StreamSupport.stream(rateInfo.getDepartments())
                                .map(Department::getCity)
                                .distinct()
                                .sorted(String.CASE_INSENSITIVE_ORDER)
                                .collect(Collectors.toList());
                        view.fillInCities(cities);
                    }

                    @Override
                    public void onFailure(Call<RateInfo> call, Throwable t) {
                        Log.e("app", t.getMessage(), t);
                        view.showMessage(t.getMessage());
                    }
                });
    }

    @Override
    public void showDepartmentLocation(Department department) {
        view.showAtMap(department);
    }

    @Override
    public void showDepartmentsRates(Department department) {
        view.showDepartmentsRates(department);
    }

    @Override
    public void filterDepartmentsByText(CharSequence text) {
        searchText = text.toString().toLowerCase();
        view.displayDepartments(filterDepartments(getDepartmentPredicateByText(searchText)));
    }

    private List<Department> filterDepartments(Predicate<Department> predicate) {
        if (rateInfo == null) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(rateInfo.getDepartments())
                .filter(predicate)
                .sorted((a, b) -> String.CASE_INSENSITIVE_ORDER.compare(a.getLabel(), b.getAddress()))
                .collect(Collectors.toList());
    }

    private Predicate<Department> getDepartmentPredicateByText(String searchText) {
        return it -> searchText == null || (
                it.getLabel().toLowerCase().contains(searchText)
                        || it.getAddress().toLowerCase().contains(searchText));
    }

    @Override
    public void filterDepartmentsByCityId(int cityId) {
        if (cities != null && cityId >= 0 && cityId < cities.size()) {
            String city = cities.get(cityId);
            Predicate<Department> departmentPredicateByText = getDepartmentPredicateByText(searchText);
            Predicate<Department> departmentPredicateByCity = getDepartmentPredicateByCity(city);
            final Predicate<Department> departmentPredicate = it -> departmentPredicateByText.test(it) && departmentPredicateByCity.test(it);
            view.displayDepartments(filterDepartments(departmentPredicate));
        } else {
            resetCity();
        }
    }

    private Predicate<Department> getDepartmentPredicateByCity(String city) {
        return it -> city.equals(it.getCity());
    }

    @Override
    public void resetCity() {
        view.displayDepartments(filterDepartments(getDepartmentPredicateByText(searchText)));
    }

}
