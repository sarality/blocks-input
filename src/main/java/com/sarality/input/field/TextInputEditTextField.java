package com.sarality.input.field;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;

/**
 * A field based on a {@link TextInputEditText} Input Control.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class TextInputEditTextField implements InputField {

  private final int fieldId;

  private TextInputEditText field;

  public TextInputEditTextField(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override public int getFieldId() {
    return fieldId;
  }

  @Override
  public void init(Activity activity) {
    field = (TextInputEditText) activity.findViewById(fieldId);
  }

  @Override
  public String extract(Activity activity) {
    return field.getText().toString();
  }
}
