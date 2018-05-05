package org.dalol.habeshamusic.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 22/04/2018 at 21:00.
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getParentFragment() == null) {
            setRetainInstance(true);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
            container.clearDisappearingChildren();
        }

        System.out.println("Created " + getClass().getSimpleName());

       /// View view = getView();

        if (mRootView == null) {
            mRootView = inflater.inflate(getContentView(), container, false);
            bindView(mRootView);
        }
        //else {
//            ViewGroup parent = (ViewGroup) view.getParent();
//            if (parent != null) {
//                parent.removeView(view);
//                System.out.println("Already Created " + getClass().getSimpleName() + " has parent and removed");
//            }
       // }
        return mRootView;
    }

    @CallSuper
    protected void bindView(View view) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
            System.out.println("Already Created " + getClass().getSimpleName() + " has parent and removed");
        }
    }

    protected abstract int getContentView();
}
