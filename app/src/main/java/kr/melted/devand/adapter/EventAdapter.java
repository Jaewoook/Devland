package kr.melted.devand.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.melted.devand.EventActivity;
import kr.melted.devand.R;
import kr.melted.devand.network.model.Event;

/**
 * Created by Envy on 2015-12-20.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {


    private static final int ITEMVIEW_LAYOUT_RESOURCE = R.layout.main_list;

    private List<Event> events;

    public EventAdapter() {
    }

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(ITEMVIEW_LAYOUT_RESOURCE, parent, false);
        return new EventHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EventHolder holder, int position) {
        switch (position) {
            case 0:
                holder.itemView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.bg));
                break;
            case 1:
                holder.itemView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.ex1));
                break;
            case 2:
                holder.itemView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.a));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), EventActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.title.setText(events.get(position).name);
        holder.subtitle.setText(events.get(position).description);
    }

    @Override
    public int getItemCount() {
        return events != null ? events.size() : 0;
    }

    public static class EventHolder extends RecyclerView.ViewHolder {


        private TextView title, subtitle;

        public EventHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.main_text);
            subtitle = (TextView) itemView.findViewById(R.id.descript_text);
        }
    }
}
