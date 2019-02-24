package com.padcmyanmar.padc7.hellofragments.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc7.hellofragments.R;

public class OneFragment extends Fragment {

    private static final String ARG_DATA_TO_FRAGMENT = "ARG_DATA_TO_FRAGMENT";

    public static OneFragment newInstance(String dataToFragment) {
        OneFragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_DATA_TO_FRAGMENT, dataToFragment);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String dataForFragment = bundle.getString(ARG_DATA_TO_FRAGMENT);
            Log.i("", "dataToFragment + " + dataForFragment);
        }

        return view;
    }
}
