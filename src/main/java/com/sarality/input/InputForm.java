package com.sarality.input;

import android.app.Activity;

import com.sarality.input.error.ErrorMessage;
import com.sarality.input.error.ErrorRenderer;
import com.sarality.input.field.EditTextField;
import com.sarality.input.field.InputField;
import com.sarality.input.field.InputType;
import com.sarality.input.field.TextInputEditTextField;
import com.sarality.input.validator.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that manages the input field in an activity or fragment and returns a data object.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class InputForm {

  private final List<InputField> fieldList = new ArrayList<>();
  private final FieldValueProvider valueProvider = new FieldValueProvider();
  private final Map<Integer, List<InputValidator>> validatorListMap = new HashMap<>();


  public InputForm withField(int fieldId, InputType fieldType) {
    if (InputType.TEXT_INPUT_EDIT_TEXT.equals(fieldType)) {
      fieldList.add(new TextInputEditTextField(fieldId));
    } else if (InputType.EDIT_TEXT.equals(fieldType)) {
      fieldList.add(new EditTextField(fieldId));
    } else {
      throw new IllegalArgumentException("Field of the given type are not supported " + fieldType);
    }
    return this;
  }

  public InputForm withField(int fieldId, InputType fieldType, Validator validator, ErrorMessage errorMessage) {
    return withField(fieldId, fieldType).withValidator(fieldId, validator, errorMessage);
  }

  public InputForm withValidator(int fieldId, Validator validator, ErrorMessage errorMessage) {
    if (!validatorListMap.containsKey(fieldId)) {
      validatorListMap.put(fieldId, new ArrayList<InputValidator>());
    }
    List<InputValidator> validatorList = validatorListMap.get(fieldId);
    validatorList.add(new InputValidator(fieldId, validator, errorMessage));
    return this;
  }


  public FieldValueProvider readValues(Activity activity) {
    for (InputField field : fieldList) {
      field.init(activity);
      valueProvider.addValue(field.getFieldId(), field.extract(activity));
    }
    return valueProvider;
  }

  public FieldValueProvider getFieldValueProvider() {
    return valueProvider;
  }

  public boolean validate(Activity activity) {
    boolean isValidForm = true;
    for (Integer fieldId : validatorListMap.keySet()) {
      boolean isValidField = validateField(activity, fieldId);
      isValidForm = isValidForm & isValidField;
    }
    return isValidForm;
  }

  private boolean validateField(Activity activity, int fieldId) {
    boolean isValid = true;
    List<InputValidator> validatorList = validatorListMap.get(fieldId);
    for (InputValidator validator : validatorList) {
      if (!validator.getValidator().isValid(valueProvider)) {
        isValid = false;
        displayError(activity, validator.getErrorMessage());
        break;
      } else {
        resetError(activity, validator.getErrorMessage().getErrorRenderer());
      }
    }
    return isValid;
  }

  private void resetError(Activity activity, ErrorRenderer renderer) {
    renderer.init(activity);
    renderer.resetError(activity);
  }

  private void displayError(Activity activity, ErrorMessage errorMessage) {
    ErrorRenderer renderer = errorMessage.getErrorRenderer();
    renderer.init(activity);
    renderer.displayError(activity, errorMessage.getMessageResourceId());
  }
}
