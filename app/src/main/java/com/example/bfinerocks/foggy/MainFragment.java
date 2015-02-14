package com.example.bfinerocks.foggy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfinerocks.foggy.models.FogLevel;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * Created by BFineRocks on 1/16/15.
 */


public class MainFragment extends BaseFragment implements FogView {

    @Inject FogSetPresenter fogSetPresenter;

    @InjectView(R.id.selection_screen_spinner)
    Spinner selectionSpinner;
    @InjectView(R.id.selection_screen_reminder_selection)
    TextView selectionText;
    @InjectView(R.id.selection_screen_done_btn)
    Button doneButton;

    private ArrayAdapter spinnerAdapter;
    private FogLevel userSelectedFogLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.fog_levels,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectionSpinner.setAdapter(spinnerAdapter);

        return view;
    }

    @OnItemSelected(R.id.selection_screen_spinner)
    public void userSelectionMade(int position){
        Log.i("selected", spinnerAdapter.getItem(position).toString());
        fogSetPresenter.onItemSelected(spinnerAdapter, position);

    }


    @OnClick(R.id.selection_screen_done_btn)
    public void doneButton(){
        fogSetPresenter.onClick();

    }

    @Override
    public void showSettingsSaved(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateTextView(String text) {
        selectionText.setText(text);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this, this));
    }
}
