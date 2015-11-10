package org.kulabukhov.android.commons.other;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

public class Typefaces {
	private static final String TAG = "Typefaces";

	private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

	public static Typeface get(Context c, String fontName) {
		synchronized (cache) {
			if (!cache.containsKey(fontName)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							String.format("fonts/%s.ttf", fontName));
					cache.put(fontName, t);
				} catch (Exception e) {
					Log.e(TAG,
							"Could not get typeface '" + fontName + "' because " + e.getMessage());
					return null;
				}
			}
			return cache.get(fontName);
		}
	}
}
