package org.dalol.habeshamusic.ui.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.dalol.habeshamusic.ui.base.BaseFragmentController;
import org.dalol.habeshamusic.ui.features.genres.AllGenreMusicFragment;

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 22/04/2018 at 21:12.
 */
public class MainFragmentController extends BaseFragmentController {

    public static MainFragmentController newInstance() {

        Bundle args = new Bundle();

        MainFragmentController fragment = new MainFragmentController();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Fragment createFragment() {
        return AllGenreMusicFragment.newInstance();
    }
}
