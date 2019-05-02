package com.bf.android2flutter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.flutter.plugin.common.MethodChannel;


public class FragmentFlutterView extends Fragment {

    public interface OnFragmentTwoInteractionListener{
        void onFrag2NavAwayClick();
    }

    private static final String TAG = FragmentFlutterView.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";
    private static final String CHANNEL = "com.example.2flutter/comtest";

    private String mParam1;
    private MethodChannel methodChannel;
    private OnFragmentTwoInteractionListener mListener;

    @BindView(R.id.btn_showfrag1)
    Button mBtnShowFrag1;

    public FragmentFlutterView() {
        // Required empty public constructor
    }

    public static FragmentFlutterView newInstance(String param1) {
        Log.d(TAG, "newInstance: ");
        FragmentFlutterView fragment = new FragmentFlutterView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
    
    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
        if (context instanceof OnFragmentTwoInteractionListener) {
            mListener = (OnFragmentTwoInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach: ");
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.btn_showfrag1)
    public void btnShowFrag1_onClick(Button btn){
        showFrag1();
    }

    private void showFrag1() {
        if (mListener != null) {
            mListener.onFrag2NavAwayClick();
        }
    }

}
