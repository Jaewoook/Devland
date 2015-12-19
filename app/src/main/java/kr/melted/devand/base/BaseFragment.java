package kr.melted.devand.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Envy on 2015-12-19.
 */
public abstract class BaseFragment extends Fragment {


    private View rootView;
    private int layoutRes;

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(layoutRes, container, false);
        init();
        initView();
        return rootView;
    }

    protected abstract void init();
    protected abstract void initView();

    public void setLayoutRes(int resid) {
        layoutRes = resid;
    }
}
