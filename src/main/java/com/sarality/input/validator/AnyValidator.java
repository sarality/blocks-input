package com.sarality.input.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * A composite validator that is composed of a list of validators. It is valid if ANY of the validators is valid.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class AnyValidator implements Validator {

  private final List<Validator> validatorList = new ArrayList<>();

  public AnyValidator(List<Validator> validatorList) {
    if (validatorList != null) {
      this.validatorList.addAll(validatorList);
    }
  }

  @Override
  public boolean isValid(FieldValueProvider valueProvider) {
    for (Validator validator : validatorList) {
      if (validator.isValid(valueProvider)) {
        return true;
      }
    }
    return false;
  }
}
