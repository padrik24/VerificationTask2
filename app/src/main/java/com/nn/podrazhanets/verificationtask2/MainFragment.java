package com.nn.podrazhanets.verificationtask2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private SeekBar mSeekBar;
    private TextView mTextView;

    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mTextView.setText(progress + "%");

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            mTextView.setTextSize(25f);
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            mTextView.setTextSize(15f);
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("MyFirstProject-" + MainFragment.class.getName() , "onCreateView()");
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        mSeekBar = v.findViewById(R.id.seekBar);
        mTextView = v.findViewById(R.id.seekBarValue);

        return v;
    }

    public static MainFragment newInstance() {
        Log.d("MyFirstProject-" + MainFragment.class.getName() , "newInstance()");
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mSeekBar.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
    }
}
