package com.nn.podrazhanets.verificationtask2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment {

    private RadioGroup mRadioGroupSearch;
    @SuppressWarnings("FieldCanBeLocal")
    private RadioButton mRadioButtonGoogle;
    @SuppressWarnings("FieldCanBeLocal")
    private RadioButton mRadioButtonYandex;
    @SuppressWarnings("FieldCanBeLocal")
    private RadioButton mRadioButtonBing;

    private SharedPreferencesHelper mSharedPreferencesHelper;

    private RadioGroup.OnCheckedChangeListener mOnSearchCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.radioButtonGoogle:
                    mSharedPreferencesHelper.setSearchSystem(checkedId);
                    break;
                case R.id.radioButtonYandex:
                    mSharedPreferencesHelper.setSearchSystem(checkedId);
                    break;
                case R.id.radioButtonBing:
                    mSharedPreferencesHelper.setSearchSystem(checkedId);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_fragment, container, false);
        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mRadioGroupSearch = v.findViewById(R.id.radioGroupSearch);
        mRadioButtonGoogle = v.findViewById(R.id.radioButtonGoogle);
        mRadioButtonYandex = v.findViewById(R.id.radioButtonYandex);
        mRadioButtonBing = v.findViewById(R.id.radioButtonBing);

        switch(mSharedPreferencesHelper.getSearchSystem()) {
            case R.id.radioButtonGoogle:
                mRadioButtonGoogle.setChecked(true);
                break;
            case R.id.radioButtonYandex:
                mRadioButtonYandex.setChecked(true);
                break;
            case R.id.radioButtonBing:
                mRadioButtonBing.setChecked(true);
                break;
        }
        return v;
    }

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mRadioGroupSearch.setOnCheckedChangeListener(mOnSearchCheckedChangeListener);
    }
}
