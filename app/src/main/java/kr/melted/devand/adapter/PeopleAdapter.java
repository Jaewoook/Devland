package kr.melted.devand.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.melted.devand.R;
import kr.melted.devand.RequestDialog;
import kr.melted.devand.network.model.People;

/**
 * Created by Envy on 2015-12-19.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder> {


    private static final int ITEMVIEW_LAYOUT_RESOURCE = R.layout.item_people_list;

    private ArrayList<People> people;
    private FragmentManager fm;

    public PeopleAdapter(FragmentManager fm) {
        people = new ArrayList<People>();
        people.add(new People("안재욱", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("박성민", "개발자", "안녕하세여", "앱잼"));
        people.add(new People("박주형", "기획자", "안녕하세여", "앱잼"));
        people.add(new People("하기봉", "디자이너", "안녕하세여", "앱잼"));
        people.add(new People("정의준", "디자이너", "안녕하세여", "앱잼"));
        this.fm = fm;
    }

    @Override
    public PeopleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(ITEMVIEW_LAYOUT_RESOURCE, parent, false);
        return new PeopleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeopleHolder holder, final int position) {
        holder.bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestDialog dialog = new RequestDialog(people.get(position).name, "안재욱");
                dialog.show(fm, "dialog");
            }
        });
        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestDialog dialog = new RequestDialog(people.get(position).name, "안재욱");
                dialog.show(fm, "dialog");
            }
        });
        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestDialog dialog = new RequestDialog(people.get(position).name, "안재욱");
                dialog.show(fm, "dialog");
            }
        });
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
        public LinearLayout bar;
        public ImageButton image1, image2;

        public PeopleHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.people_text1);
            position = (TextView) itemView.findViewById(R.id.people_text2);
            comment = (TextView) itemView.findViewById(R.id.people_text3);
            bar = (LinearLayout) itemView.findViewById(R.id.bar);
            image1 = (ImageButton) itemView.findViewById(R.id.image1);
            image2 = (ImageButton) itemView.findViewById(R.id.image2);
        }
    }


}
