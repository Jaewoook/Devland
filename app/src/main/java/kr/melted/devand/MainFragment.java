package kr.melted.devand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kr.melted.devand.adapter.EventAdapter;
import kr.melted.devand.base.BaseFragment;
import kr.melted.devand.network.base.APIAdapter;
import kr.melted.devand.network.model.Event;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Envy on 2015-12-20.
 */
public class MainFragment extends BaseFragment {


    private static final int LAYOUT_RESOURCE = R.layout.fragment_main;

    private RecyclerView list;
    private LinearLayoutManager llManager;
    private EventAdapter eventAdapter;

    private APIAdapter.APIService apiService = APIAdapter.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRes(LAYOUT_RESOURCE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void init() {
        llManager = new LinearLayoutManager(getContext());
        eventAdapter = new EventAdapter();

        apiService.getEventList(new Callback<List<Event>>() {
            @Override
            public void onResponse(Response<List<Event>> response, Retrofit retrofit) {

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
}
