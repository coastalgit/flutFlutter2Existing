package com.bf.android2flutter;

import android.content.Context;
import android.net.Uri;
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


public class FragmentOne extends Fragment {

    public interface OnFragmentOneInteractionListener{
        void onFrag1NavAwayClick();
    }

    private static final String TAG = FragmentOne.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private OnFragmentOneInteractionListener mListener;

    @BindView(R.id.btn_showfrag2)
    Button mBtnShowFrag2;

    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance(String param1) {
        Log.d(TAG, "newInstance: ");
        FragmentOne fragment = new FragmentOne();
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
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
        if (context instanceof OnFragmentOneInteractionListener) {
            mListener = (OnFragmentOneInteractionListener) context;
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

    @OnClick(R.id.btn_showfrag2)
    public void btnShowFrag2_onClick(Button btn){
        showFrag2();
    }

    private void showFrag2() {
        if (mListener != null) {
            mListener.onFrag1NavAwayClick();
        }
    }

}
