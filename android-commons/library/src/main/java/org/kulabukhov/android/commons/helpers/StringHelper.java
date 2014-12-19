package org.kulabukhov.android.commons.helpers;

import org.jetbrains.annotations.Nullable;

/**
 * Helper class to work with strings
 */
public class StringHelper {

	/**
	 * Capitalizes given string
	 * @param string string to capitalize
	 * @return capitalized string or null if given string was null
	 */
	@Nullable
	public static String capitalize(@Nullable String string) {
		if (string == null || string.length() == 0) {
			return "";
		}
		char first = string.charAt(0);
		if (Character.isUpperCase(first)) {
			return string;
		} else {
			return Character.toUpperCase(first) + string.substring(1);
		}
	}

}
