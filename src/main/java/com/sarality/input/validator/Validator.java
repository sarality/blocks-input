package com.sarality.input.validator;

import com.sarality.input.FieldValueProvider;

/**
 * Validates a field or set of fields, the value(s) for which are provided bu the {@link FieldValueProvider}.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface Validator {

  boolean isValid(FieldValueProvider valueProvider);
}
