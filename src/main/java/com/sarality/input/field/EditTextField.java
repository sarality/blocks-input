package com.sarality.input.field;

import android.app.Activity;
import android.widget.EditText;

import com.sarality.input.error.ErrorRenderer;

/**
 * A field based on an {@link EditText} Input Control.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EditTextField implements InputField, ErrorRenderer {

  private boolean isInitialized = false;
  private final int fieldId;

  private EditText field;

  public EditTextField(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override public int getFieldId() {
    return fieldId;
  }

  @Override
  public void init(Activity activity) {
    if (!isInitialized) {
      field = (EditText) activity.findViewById(fieldId);
      isInitialized = true;
    }
  }

  @Override
  public String extract(Activity activity) {
    return field.getText().toString();
  }

  @Override
  public void displayError(Activity activity, int messageResourceId) {
    field.setError(activity.getString(messageResourceId));
  }

  @Override
  public void resetError(Activity activity) {
    field.setError(null);
  }
}
