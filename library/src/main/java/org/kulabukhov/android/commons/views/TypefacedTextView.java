package org.kulabukhov.android.commons.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import org.kulabukhov.android.commons.R;
import org.kulabukhov.android.commons.other.Typefaces;

/**
 * TextView extension that support custom fonts.
 * <br>
 * Font can be set via 'typeface' attribure in xml or setter method {@link #setTypeface(String)}.
 * <br>
 * All custom font expected to be in .ttf format and located in application 'assets/fonts/' directory
 */
public class TypefacedTextView extends TextView {
	

	public TypefacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        parseAttributes(context, attrs);
    }
	
	public TypefacedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		parseAttributes(context, attrs);
	}
	
	private void parseAttributes(Context context, AttributeSet attrs) {
		//Typeface.createFromAsset doesn't work in the layout editor. Skipping...
        if (isInEditMode()) {
            return;
        }

        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypefacedTextView);
        String fontName = styledAttrs.getString(R.styleable.TypefacedTextView_typeface);
        styledAttrs.recycle();

        if (fontName != null) {
            Typeface typeface = Typefaces.get(context, fontName);
            if (typeface != null) {
            	setTypeface(typeface);
            }
        }
	}

    public void setTypeface(String fontName) {
        if (fontName != null && this.getContext() != null) {
            Typeface typeface = Typefaces.get(this.getContext(), fontName);
            if (typeface != null) {
                setTypeface(typeface);
            }
        }
    }

}
