package org.kulabukhov.android.commons.helpers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import org.jetbrains.annotations.Nullable;

/**
 * Created by gkulabukhov on 25/06/15.
 */
public class SoftKeyboardHelper {

	/**
	 * Hides soft keyboard
	 * @param activity activity
	 */
	public static void hideSoftKeyboard(@Nullable Activity activity) {
		if (activity == null) {
			return;
		}

		if (activity.getCurrentFocus() != null) {
			InputMethodManager inputManager =
					(InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		} else {
			activity.getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		}
	}

	/**
	 * Show soft keyboard for view
	 * @param activity activity
	 * @param view view for which keyboard should be shown
	 */
	public static void showSoftKeyboard(@Nullable Activity activity, @Nullable View view) {
		if (activity == null || view == null) {
			return;
		}

		InputMethodManager inputManager =
				(InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
	}

}
