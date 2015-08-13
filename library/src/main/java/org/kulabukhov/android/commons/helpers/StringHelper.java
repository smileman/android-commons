package org.kulabukhov.android.commons.helpers;

import android.support.annotation.Nullable;

/**
 * Helper class to work with strings
 */
public class StringHelper {

	/**
	 * Capitalizes given string
	 *
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

	/**
	 * Checks if given string is empty or contains only empty characters (for example, whitespaces)
	 *
	 * @param string string to check. May be null
	 * @return true, if given string is null, has 0 length or contains only empty characters. Otherwise returns false.
	 */
	public static boolean isEmptyOrWhitespaced(@Nullable String string) {
		return string == null || string.length() == 0 || string.matches("\\s*");
	}

}
