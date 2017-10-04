package com.slesh.mtbbank.ui.main.fragment.department;


import com.slesh.mtbbank.client.dto.Department;
import com.slesh.mtbbank.client.dto.RateInfo;

import java.util.List;

public interface DepartmentFragmentContract {

    interface View {
        void displayData(RateInfo rateInfo);

        void showMessage(String message);

        void displayDepartments(List<Department> departments);

        void fillInCities(List<String> cities);

        void showAtMap(Department department);

        void showDepartmentsRates(Department department);
    }

    interface Presenter {
        void loadRatesInfo();

        void showDepartmentLocation(Department department);

        void showDepartmentsRates(Department department);

        void filterDepartmentsByText(CharSequence text);

        void filterDepartmentsByCityId(int id);

        void resetCity();
    }

}
