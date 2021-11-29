package com.example.canvasuistarter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.canvasuistarter.api.USUCanvasAPI;
import com.example.canvasuistarter.api.models.Course;
import com.example.canvasuistarter.api.models.CourseFragment;
import com.example.canvasuistarter.api.models.UpcomingEvent;
import com.example.canvasuistarter.api.models.UpcomingEventFragment;
import com.example.canvasuistarter.api.models.User;
import com.example.canvasuistarter.api.models.UserFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<UpcomingEvent> events = new ArrayList<>();

        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar materialToolbar = findViewById(R.id.topAppBar);
        materialToolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });
        NavigationView navigationView = findViewById(R.id.design_navigation_view);
        USUCanvasAPI api = USUCanvasAPI.getInstance(this);


        UserFragment userFragment = new UserFragment();
        UpcomingEventFragment upcomingEventFragment = new UpcomingEventFragment();
        api.getUser(new USUCanvasAPI.OnRequestCompleteListener<User>() {
            @Override
            public void onComplete(User[] result, String errorMessage) {
                Menu menu = navigationView.getMenu();
                MenuItem userName = menu.findItem(R.id.user_name);
                userName.setTitle(result[0].name);
                userName.setVisible(true);
                User user = new User();
                user.id = result[0].id;
                user.name = result[0].name;

                userFragment.setUser(user);
            }
        });
        api.getCourses(new USUCanvasAPI.OnRequestCompleteListener<Course>() {
            @Override
            public void onComplete(Course[] result, String errorMessage) {
                for(int i = 0; i < result.length; i++){
                    Course course = new Course();
                    course.id = result[i].id;
                    course.name = result[i].name;
                    courses.add(course);
                }
            }
        });
        api.getUpcomingEvents(new USUCanvasAPI.OnRequestCompleteListener<UpcomingEvent>() {
            @Override
            public void onComplete(UpcomingEvent[] result, String errorMessage) {
                for(int i = 0;i < result.length; i++){
                    UpcomingEvent upcomingEvent = new UpcomingEvent();
                    upcomingEvent.title = result[i].title;
                    events.add(upcomingEvent);
                }
                upcomingEventFragment.setEvents(events);

                CourseFragment courseFragment = new CourseFragment();


                courseFragment.setCourses(courses);
                if(savedInstanceState == null){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.fragment_container_view_tag, courseFragment)


                            .commit();
                } navigationView.setNavigationItemSelectedListener(menuItem -> {
                    menuItem.setChecked(true);


                    if (menuItem.getItemId() == R.id.User_item) {
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_container_view_tag, userFragment)


                                .commit();
                    } else if (menuItem.getItemId() == R.id.Courses_item) {
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_container_view_tag, courseFragment)


                                .commit();
                    } else if (menuItem.getItemId() == R.id.UpcomingEventsItem) {
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_container_view_tag, upcomingEventFragment)


                                .commit();
                    }
                    return true;
                });

            }
        });
      }
}