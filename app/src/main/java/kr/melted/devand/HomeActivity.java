package kr.melted.devand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import kr.melted.devand.adapter.EventAdapter;
import kr.melted.devand.base.BaseActivity;
import kr.melted.devand.network.base.APIAdapter;
import kr.melted.devand.network.model.Event;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeActivity extends BaseActivity {


    private MemberListFragment memberListFragment;
    private RecyclerView list;
    private LinearLayoutManager llmanager;
    private EventAdapter adapter;

    private APIAdapter.APIService apiService = APIAdapter.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutResource(R.layout.activity_home);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {

        apiService.getEventList(new Callback<List<Event>>() {
            @Override
            public void onResponse(Response<List<Event>> response, Retrofit retrofit) {
                for(int i = 0; i < response.body().size(); i++) {
                    adapter = new EventAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    @Override
    protected void initView() {
        memberListFragment = (MemberListFragment) getSupportFragmentManager().findFragmentById(R.id.content);

        list = (RecyclerView) findViewById(R.id.main_list);
        list.setLayoutManager(llmanager);
        list.setAdapter(adapter);

    }

    @Override
    protected void initMenu() {

    }
}