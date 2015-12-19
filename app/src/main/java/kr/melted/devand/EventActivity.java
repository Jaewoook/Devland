package kr.melted.devand;

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

/**
 * Created by Envy on 2015-12-20.
 */
public class EventActivity extends BaseActivity {


    private static final int LAYOUT_RESOURCE = R.layout.fragment_main;

    private RecyclerView list;
    private LinearLayoutManager llManager;
    private EventAdapter eventAdapter;

    private APIAdapter.APIService apiService = APIAdapter.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        llManager = new LinearLayoutManager(this);
        eventAdapter = new EventAdapter();

        apiService.getEventList(new Callback<List<Event>>() {
            @Override
            public void onResponse(Response<List<Event>> response, Retrofit retrofit) {
                for(int i = 0; i < response.body().size(); i++) {
                    eventAdapter = new EventAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void initView() {
        list = (RecyclerView) findViewById(R.id.main_list);
        list.setLayoutManager(llManager);
        list.setAdapter(eventAdapter);
    }

    @Override
    protected void initMenu() {

    }
}
