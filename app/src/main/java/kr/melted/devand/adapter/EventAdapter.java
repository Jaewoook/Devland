package kr.melted.devand.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kr.melted.devand.R;
import kr.melted.devand.network.model.Event;

/**
 * Created by Envy on 2015-12-20.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {


    private static final int ITEMVIEW_LAYOUT_RESOURCE = R.layout.main_list;

    private ArrayList<Event> events;

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(ITEMVIEW_LAYOUT_RESOURCE, parent, false);
        return new EventHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
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
