package com.sarality.input.validator;

import android.text.TextUtils;

/**
 * Validator that checks if the value is not empty or null.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class NonEmptyValueValidator implements Validator {

  private final int fieldId;

  public NonEmptyValueValidator(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override
  public boolean isValid(FieldValueProvider valueProvider) {
    String value = valueProvider.getValue(fieldId);
    return !TextUtils.isEmpty(value);
  }
}
