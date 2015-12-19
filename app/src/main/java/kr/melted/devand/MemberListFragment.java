package kr.melted.devand;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.melted.devand.adapter.PeopleAdapter;
import kr.melted.devand.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberListFragment extends BaseFragment {


    private static final int LAYOUT_RESOURCE = R.layout.fragment_member_list;

    private LinearLayoutManager llManager;
    private RecyclerView list;
    private PeopleAdapter peopleAdapter;

    public MemberListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayoutRes(LAYOUT_RESOURCE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void init() {
        peopleAdapter = new PeopleAdapter();
        llManager = new LinearLayoutManager(getContext());
    }

    @Override
    protected void initView() {
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(llManager);
        list.setAdapter(peopleAdapter);
    }
}

