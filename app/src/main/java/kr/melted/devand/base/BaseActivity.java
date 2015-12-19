package kr.melted.devand.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Envy on 2015-12-19.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private int layoutRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes);
        init();
        initView();
        initMenu();
    }

    protected abstract void init();
    protected abstract void initView();
    protected abstract void initMenu();

    public void setLayoutResource(int layoutRes) {
        this.layoutRes = layoutRes;
    }
}
