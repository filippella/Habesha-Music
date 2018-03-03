package org.dalol.habeshamusic.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import org.dalol.habeshamusic.R;
import org.dalol.habeshamusic.data.providers.FontTypefaceProvider;

/**
 * Created by filippo on 13/01/2018.
 */

public class HMTextView extends AppCompatTextView {

    public HMTextView(Context context) {
        super(context);
        initialize(context, null);
    }

    public HMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public HMTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        if (isInEditMode()) {
            return;
        }
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.HMTextView, 0, 0);
        if (attr != null) {
            try {
                int fontStyle = attr.getInt(R.styleable.HMTextView_custom_text_font_style, 0);
                setTypeface(FontTypefaceProvider.getInstance().getTypeface(fontStyle));
            } finally {
                attr.recycle();
            }
        }
    }
}
