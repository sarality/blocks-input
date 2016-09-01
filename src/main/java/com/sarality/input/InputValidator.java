package com.sarality.input;

import com.sarality.input.error.ErrorMessage;
import com.sarality.input.validator.Validator;

/**
 * Wrapper over a validator alog with the field that should trigger the validator as well as the error message to
 * be shown when the validation fails.
 *
 * @author abhideep@ (Abhideep Singh)
 */
class InputValidator {
  private final int fieldId;
  private final Validator validator;
  private final ErrorMessage errorMessage;

  InputValidator(int fieldId, Validator validator,
      ErrorMessage errorMessage) {
    this.fieldId = fieldId;
    this.validator = validator;
    this.errorMessage = errorMessage;
  }

  int getFieldId() {
    return fieldId;
  }

  Validator getValidator() {
    return validator;
  }

  ErrorMessage getErrorMessage() {
    return errorMessage;
  }
}
