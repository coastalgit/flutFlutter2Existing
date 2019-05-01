package com.bf.android2flutter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.flutter.facade.FlutterFragment;
import io.flutter.view.FlutterView;


public class FragmentFlutter extends FlutterFragment {

    public interface OnFragmentFlutterInteractionListener{
        void onFragFlutterNavAwayClick();
    }

    private static final String TAG = FragmentFlutter.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private OnFragmentFlutterInteractionListener mListener;

    public FragmentFlutter() {
        // Required empty public constructor
    }

    public static FragmentFlutter newInstance(String param1) {
        Log.d(TAG, "newInstance: ");
        FragmentFlutter fragment = new FragmentFlutter();
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
    public FlutterView onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        //return super.onCreateView(inflater, container, savedInstanceState);
        FlutterView rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
        if (context instanceof OnFragmentFlutterInteractionListener) {
            mListener = (OnFragmentFlutterInteractionListener) context;
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

    private void showFrag1() {
        if (mListener != null) {
            mListener.onFragFlutterNavAwayClick();
        }
    }

}
