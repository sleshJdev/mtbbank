package com.slesh.mtbbank.ui.main.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.slesh.mtbbank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerFragment;

public class MainFragment extends DaggerFragment {

    public interface OnClickListener {

        void onDepartmensClick();

    }

    @BindView(R.id.departmens_button)
    Button departmensButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof OnClickListener) {
            OnClickListener listener = (OnClickListener) getActivity();
            departmensButton.setOnClickListener((it) -> listener.onDepartmensClick());
        }
    }

}
