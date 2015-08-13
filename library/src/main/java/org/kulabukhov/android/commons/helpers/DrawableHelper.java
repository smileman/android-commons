package org.kulabukhov.android.commons.helpers;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * Helper for working with drawables
 */
public class DrawableHelper {

	/**
	 * Returns drawable masked with color
	 *
	 * @param drawable drawable
	 * @param color color to mask drawable
	 * @return drawable with applied mask
	 */
	@NonNull
	public static Drawable getTintedDrawable(@NonNull Drawable drawable, int color) {
		Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
		DrawableCompat.setTint(wrappedDrawable, color);
		DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_ATOP);
		return wrappedDrawable;
	}

	/**
	 * Returns drawable masked with color
	 *
	 * @param drawable drawable
	 * @param colorStateList colorStateList to mask drawable
	 * @return drawable with applied mask
	 */
	@NonNull
	public static Drawable getTintedDrawable(@NonNull Drawable drawable, ColorStateList colorStateList) {
		Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
		DrawableCompat.setTintList(wrappedDrawable, colorStateList);
		DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_ATOP);
		return wrappedDrawable;
	}
}
