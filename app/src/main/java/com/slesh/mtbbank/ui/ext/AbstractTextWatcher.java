package com.slesh.mtbbank.ui.ext;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by yauheni on 10/3/17.
 */

public abstract class AbstractTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
