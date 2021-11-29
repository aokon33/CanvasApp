package com.example.canvasuistarter.api.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private ArrayList<Course> courses;
    public CourseAdapter(ArrayList<Course> courses){
        this.courses = courses;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_adapter, parent,false );


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView title = holder.itemView.findViewById(R.id.Title);
        TextView description = holder.itemView.findViewById(R.id.Description);
        title.setText(courses.get(position).name);
        description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum " +
                "commodo urna erat, nec facilisis purus egestas eu. Donec ut porttitor sem, eget " +
                "pretium ipsum. Integer velit ante, sodales id hendrerit eleifend, blandit at sapien. " +
                "Aenean tempor ligula nulla. Nam vitae pretium mauris. Sed neque mauris, dictum id " +
                "faucibus vitae, varius nec elit. Quisque quis purus fringilla, egestas nibh vitae, " +
                "ultricies mauris. Etiam molestie interdum sollicitudin. In hac habitasse platea " +
                "dictumst. Vestibulum tempor a augue sed faucibus. Vestibulum at porta nunc, a ultrices velit. ");


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder (@NonNull View itemView){
            super(itemView);
        }
    }
}
