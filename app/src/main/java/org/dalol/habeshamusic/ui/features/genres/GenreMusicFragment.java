package org.dalol.habeshamusic.ui.features.genres;

import android.os.Bundle;
import android.view.View;

import org.dalol.habeshamusic.R;
import org.dalol.habeshamusic.ui.base.BaseChildFragment;

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 22/04/2018 at 21:59.
 */
public class GenreMusicFragment extends BaseChildFragment {

    public static GenreMusicFragment newInstance() {

        Bundle args = new Bundle();

        GenreMusicFragment fragment = new GenreMusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.common_simple_list;
    }

    @Override
    protected void bindView(View view) {
        super.bindView(view);

    }
}
