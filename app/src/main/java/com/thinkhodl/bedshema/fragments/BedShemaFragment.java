package com.thinkhodl.bedshema.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thinkhodl.bedshema.R;
import com.thinkhodl.bedshema.backend.PrayerAdapter;
import com.thinkhodl.bedshema.backend.PrayerLists;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class BedShemaFragment extends Fragment {
    @Nullable
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    public BedShemaFragment() {
        // Required empty public constructor
    }


    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.recyclerview_fragment_layout, container, false);

        ButterKnife.bind(this, rootView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        PrayerAdapter mAdapter = new PrayerAdapter(PrayerLists.getmShemaPrayer(), getActivity());
        mRecyclerView.setAdapter(mAdapter);

        Toolbar mToolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar);
        TextView mToolbarTitle = mToolbar.findViewById(R.id.toolbar_title);

        if(mToolbarTitle != null)
            mToolbarTitle.setText(getString(R.string.shema_english));
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
