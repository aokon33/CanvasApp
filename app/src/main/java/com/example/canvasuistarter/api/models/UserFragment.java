package com.example.canvasuistarter.api.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.canvasuistarter.R;

public class UserFragment extends Fragment {
    User user;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        TextView profileName = view.findViewById(R.id.profile_name);
        TextView aboutUser = view.findViewById(R.id.about_user);
        aboutUser.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum " +
                "commodo urna erat, nec facilisis purus egestas eu. Donec ut porttitor sem, eget " +
                "pretium ipsum. Integer velit ante, sodales id hendrerit eleifend, blandit at sapien. " +
                "Aenean tempor ligula nulla. Nam vitae pretium mauris. Sed neque mauris, dictum id " +
                "faucibus vitae, varius nec elit. Quisque quis purus fringilla, egestas nibh vitae, " +
                "ultricies mauris. Etiam molestie interdum sollicitudin. In hac habitasse platea " +
                "dictumst. Vestibulum tempor a augue sed faucibus. Vestibulum at porta nunc, a ultrices velit. ");
        profileName.setText(user.name);
        return view;
    }
    public void setUser(User user) {
        this.user = user;
    }
}


