package com.application.mydsu.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.application.mydsu.R;

public class FragmentEnd extends Fragment {
    public FragmentEnd() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_end, container, false);
        Button endBtn = (Button) view.findViewById(R.id.endBtn);
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAboutMeTutorial = new Intent(view.getContext(), AboutMeTutorial.class);
                startActivity(intentAboutMeTutorial);
            }
        });
        return view;
    }
}
