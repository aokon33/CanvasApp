package com.example.canvasuistarter.api.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.R;

import java.util.ArrayList;

public class UpcomingEventFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<UpcomingEvent> upcomingEvents;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcomingevent_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_upcoming_events);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new UpcomingEventAdapter(upcomingEvents));
        return view;
    }
    public UpcomingEventFragment(){
        super(R.layout.upcomingevent_fragment);
    }
    public void setEvents(ArrayList<UpcomingEvent> events){
        upcomingEvents = events;
    }
}
