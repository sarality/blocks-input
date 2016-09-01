package com.sarality.input.field;

import android.text.Editable;
import android.text.TextWatcher;

import com.sarality.input.validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Observes an EditText to see if the value has changed and then runs the appropriate
 * validators.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EditTextObserver implements TextWatcher {

  private final List<Validator> validatorList = new ArrayList<>();

  public EditTextObserver(List<Validator> validatorList) {
    if (validatorList != null) {
      this.validatorList.addAll(validatorList);
    }
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void afterTextChanged(Editable editable) {
    String value = editable.toString();
    for (Validator validator : validatorList) {
      //validator.isValid(value);
    }
  }
}
