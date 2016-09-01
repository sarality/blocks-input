package com.sarality.input.validator;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores and provides the value for fields in a Form
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class FieldValueProvider {

  private final Map<Integer, String> fieldValueMap = new HashMap<>();

  public void addValue(int fieldId, String value) {
    fieldValueMap.put(fieldId, value);
  }

  public String getValue(int fieldId) {
    return fieldValueMap.get(fieldId);
  }
}
