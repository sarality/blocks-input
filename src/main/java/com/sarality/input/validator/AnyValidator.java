package com.sarality.input.validator;

import com.sarality.input.FieldValueProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A composite validator that is composed of a list of validators. It is valid if ANY of the validators is valid.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class AnyValidator implements Validator {

  private final List<Validator> validatorList = new ArrayList<>();

  public AnyValidator(Validator... validators) {
    if (validators != null) {
      validatorList.addAll(Arrays.asList(validators));
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
