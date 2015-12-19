package kr.melted.devand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.melted.devand.base.BaseActivity;

public class HomeActivity extends BaseActivity {


    private MemberListFragment memberListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initView() {
        memberListFragment = (MemberListFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }

    @Override
    protected void initMenu() {

    }
}