package com.sarality.input.field;

import android.app.Activity;

/**
 * Field that the user enters data in.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface InputField {

  int getFieldId();

  void init(Activity activity);

  String extract(Activity activity);
}
