package com.sarality.input.validator;

import android.text.TextUtils;

import com.sarality.input.FieldValueProvider;

/**
 * A Validator that checks if the field value is a valid email address
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EmailFormatValidator implements Validator {

  private final int fieldId;

  public EmailFormatValidator(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override
  public boolean isValid(FieldValueProvider valueProvider) {
    String email = valueProvider.getValue(fieldId);
    return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
  }
}
