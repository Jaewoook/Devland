package kr.melted.devand.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kr.melted.devand.R;
import kr.melted.devand.network.model.People;

/**
 * Created by Envy on 2015-12-19.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder> {


    private static final int ITEMVIEW_LAYOUT_RESOURCE = R.layout.item_people_list;

    private ArrayList<People> people;

    public PeopleAdapter() {
        people = new ArrayList<People>();
        people.add(new People("안재욱", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("박성민", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("안재욱", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("안재욱", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("안재욱", "개발자", "안녕하세여", "앱잼"));
    }

    @Override
    public PeopleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(ITEMVIEW_LAYOUT_RESOURCE, parent, false);
        return new PeopleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeopleHolder holder, int position) {
        holder.name.setText(people.get(position).name);
        holder.comment.setText(people.get(position).comment);
        holder.position.setText(people.get(position).position);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class PeopleHolder extends RecyclerView.ViewHolder {


        public TextView name, position, comment;

        public PeopleHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.people_text1);
            position = (TextView) itemView.findViewById(R.id.people_text2);
            comment = (TextView) itemView.findViewById(R.id.people_text3);
        }
    }


}
