package kr.melted.devand;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.IOException;
import java.util.List;

import kr.melted.devand.adapter.EventAdapter;
import kr.melted.devand.base.BaseActivity;
import kr.melted.devand.network.base.APIAdapter;
import kr.melted.devand.network.model.Event;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeActivity extends BaseActivity {


    private MemberListFragment memberListFragment;
    private RecyclerView list;
    private LinearLayoutManager llmanager;
    private EventAdapter adapter;

    private FloatingActionButton fab;

    private APIAdapter.APIService apiService = APIAdapter.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutResource(R.layout.activity_home);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        llmanager = new LinearLayoutManager(this);
        apiService.getEventList(new Callback<List<Event>>() {
            @Override
            public void success(List<Event> events, Response response) {
                adapter = new EventAdapter(events);
                list.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    @Override
    protected void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(llmanager);
        list.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NewEvent.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initMenu() {

    }
}