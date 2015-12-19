package kr.melted.devand;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import kr.melted.devand.adapter.PeopleAdapter;
import kr.melted.devand.base.BaseActivity;

/**
 * Created by Envy on 2015-12-20.
 */
public class EventActivity extends BaseActivity {


    private static final int LAYOUT_RESOURCE = R.layout.fragment_main;

    private RecyclerView list;
    private LinearLayoutManager llManager;
    private PeopleAdapter adapter;

    // TODO 연결
    private TextView title;
    private Button join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutResource(R.layout.fragment_member_list);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        llManager = new LinearLayoutManager(this);
        adapter = new PeopleAdapter();

    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(llManager);
        list.setAdapter(adapter);
    }

    @Override
    protected void initMenu() {

    }
}
