package com.nn.podrazhanets.verificationtask2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchFragment extends Fragment {

    private EditText mEditTextSearch;
    private Button mSearchButton;

    private View.OnClickListener mOnbuttonSearchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String searchText = mEditTextSearch.getText().toString();
            searchInBrowser(searchText);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);

        mEditTextSearch = v.findViewById(R.id.editTextSearch);
        mSearchButton = v.findViewById(R.id.buttonSearch);
        return v;

    }

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mSearchButton.setOnClickListener(mOnbuttonSearchClickListener);
    }

    private void searchInBrowser(String searchText) {
        String escapedQuery = "";
        String linkToSearchEngine = "";
        SharedPreferencesHelper mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        switch(mSharedPreferencesHelper.getSearchSystem()) {
            case R.id.radioButtonGoogle:
                linkToSearchEngine = getString(R.string.link_to_google_search_engine);
                break;
            case R.id.radioButtonYandex:
                linkToSearchEngine = getString(R.string.link_to_yandex_search_engine);
                break;
            case R.id.radioButtonBing:
                linkToSearchEngine = getString(R.string.link_to_bing_search_engine);
                break;
        }
        try {
            escapedQuery = URLEncoder.encode(searchText, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        Uri uri = Uri.parse(linkToSearchEngine + escapedQuery);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
