package com.example.canvasuistarter.api.models;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.R;



import java.util.ArrayList;


public class CourseFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Course> courses = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.course, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_course);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new CourseAdapter(courses));
        return view;
    }
    public CourseFragment(){
        super(R.layout.course);
    }



    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}


