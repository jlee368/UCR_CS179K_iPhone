package com.example.judy.medium_cs179k;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Judy Lee on 2/4/2018.
 */

public class FirstFragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout,container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        return myView;
    }
}
