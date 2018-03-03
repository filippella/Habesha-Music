package org.dalol.habeshamusic.data.providers;

import android.content.Context;
import android.graphics.Typeface;

import org.dalol.habeshamusic.application.HMApplication;
import org.dalol.habeshamusic.data.UIFont;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by filippo on 13/01/2018.
 */

public final class FontTypefaceProvider implements UIFont {

    private final Map<Integer, Typeface> mFontTypefaceMap;

    private FontTypefaceProvider() {
        mFontTypefaceMap = new HashMap<>();
    }

    private final static class InstanceHolder {
        private static final FontTypefaceProvider INSTANCE = new FontTypefaceProvider();
    }

    public static FontTypefaceProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public Typeface getTypeface(Integer fontType) {
        Typeface typeface = mFontTypefaceMap.get(fontType);
        if (typeface == null) {
            Context context = HMApplication.getApplicationInstance();

            String fontName;
            switch (fontType) {
                case 0:
                    fontName = FONT_PATH_LIGHT;
                    break;
                case 1:
                    fontName = FONT_PATH_MEDIUM;
                    break;
                default:
                    fontName = FONT_PATH_BOLD;
            }

            typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            mFontTypefaceMap.put(fontType, typeface);
        }
        return typeface;
    }
}
