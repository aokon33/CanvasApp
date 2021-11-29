package com.example.canvasuistarter.api.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.R;

import java.util.ArrayList;

public class UpcomingEventAdapter extends RecyclerView.Adapter<UpcomingEventAdapter.ViewHolder> {
    ArrayList<UpcomingEvent> events;
    public UpcomingEventAdapter(ArrayList<UpcomingEvent> events) {
        this.events = events;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_event_adapter, parent, false);
        return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println(events.get(position).title);
        TextView event = holder.itemView.findViewById(R.id.event);
        event.setText(events.get(position).title);
    }


        @Override
        public int getItemCount () {
            return events.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

}
