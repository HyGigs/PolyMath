package com.example.polymath.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.polymath.R;

public class ProfileFragment extends Fragment {

    private static final String ARG_NAME = "nameUser";
    private static final String ARG_EMAIL = "emailUser";

    private String nameText;
    private String emailText;

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance(String nameUser, String emailUser) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, nameUser );
        args.putString(ARG_EMAIL, emailUser);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nameText = getArguments().getString(ARG_NAME);
            emailText = getArguments().getString(ARG_EMAIL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nameTextView = view.findViewById(R.id.nameUser);
        TextView emailTextView = view.findViewById(R.id.emailUser);
        nameTextView.setText(nameText);
        emailTextView.setText(emailText);
        return view;
    }
}
