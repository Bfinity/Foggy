package com.example.bfinerocks.foggy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by BFineRocks on 1/16/15.
 */


public class MainFragment extends Fragment {
    @InjectView(R.id.selection_screen_spinner)
    Spinner selectionSpinner;
    @InjectView(R.id.selection_screen_reminder_selection)
    TextView selectionText;
    @InjectView(R.id.selection_screen_done_btn)
    Button doneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

}
