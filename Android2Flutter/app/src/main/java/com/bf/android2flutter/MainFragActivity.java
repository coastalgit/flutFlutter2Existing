package com.bf.android2flutter;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;
import io.flutter.facade.FlutterFragment;

import static io.flutter.facade.Flutter.createView;

public class MainFragActivity extends AppCompatActivity implements FragmentOne.OnFragmentOneInteractionListener, FragmentTwo.OnFragmentTwoInteractionListener, FragmentFlutter.OnFragmentFlutterInteractionListener{

    private static final String TAG = MainFragActivity.class.getSimpleName();
    private static final String FRAGMENT_ONE = "key_frag1";
    private static final String FRAGMENT_ONE_TAG = "key_frag1tag";
    private static final String FRAGMENT_TWO = "key_frag2";
    private static final String FRAGMENT_TWO_TAG = "key_frag2tag";

    private FragmentManager mFragmentManager;
    private Fragment mFragmentOne;
    //private Fragment mFragmentTwo;
    private FragmentFlutter mFragmentTwo;

    private  ViewModelMainFrag mViewModel;

    public ViewModelMainFrag getViewModel(){
        return mViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frag);

        mViewModel = ViewModelProviders.of(this).get(ViewModelMainFrag.class);
        mFragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: NO INSTANCE");
            if (mViewModel.getActiveFragIndex() == 0)
                applyFragment(mFragmentOne, R.id.layout_main_steps, FRAGMENT_ONE_TAG);
            else
                applyFragment(mFragmentTwo, R.id.layout_main_steps, FRAGMENT_TWO_TAG);

//            mFragmentInstructions = RecipeInstructionFragment.newInstance(mViewModel.getRecipe());
//            if (mIsTwoPane) {
//                applyFragment(mFragmentInstructions, R.id.layout_main_instructions, FRAGMENT_INSTRUCTION_TAG);
//            }

        }
        else{
            Log.d(TAG, "onCreate: HAVE INSTANCE");
            mFragmentOne = mFragmentManager.getFragment(savedInstanceState, FRAGMENT_ONE);
            //mFragmentTwo = mFragmentManager.getFragment(savedInstanceState, FRAGMENT_TWO);
            mFragmentTwo = (FragmentFlutter) mFragmentManager.getFragment(savedInstanceState, FRAGMENT_TWO);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);

        try {
            if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_ONE_TAG) != null)
                getSupportFragmentManager().putFragment(outState, FRAGMENT_ONE, mFragmentOne);

            if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_TWO_TAG) != null)
                getSupportFragmentManager().putFragment(outState, FRAGMENT_TWO, mFragmentTwo);
        }
        catch (Exception exc){
            Log.e(TAG, "onSaveInstanceState: EXCEPTION:["+exc.getLocalizedMessage()+"]" );
        }
    }

    //region LifeCycle events
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    //endregion LifeCycle events

    private void applyFragment(Fragment frag, int layoutId, String fragTag){
        Log.d(TAG, "applyFragment: Tag:"+fragTag.toString()+"");

        if (frag != null)
            //mFragmentManager.beginTransaction().replace(layoutId, frag, fragTag).commit();
            switch (fragTag){
                case FRAGMENT_ONE_TAG:
                    mFragmentManager.beginTransaction().show(frag).commit();
                    if (mFragmentTwo != null)
                        mFragmentManager.beginTransaction().hide(mFragmentTwo).commit();
                    break;
                case FRAGMENT_TWO_TAG:
                    mFragmentManager.beginTransaction().show(frag).commit();
                    if (mFragmentOne != null)
                        mFragmentManager.beginTransaction().hide(mFragmentOne).commit();
                    break;
            }
        else{

            if (mFragmentManager.findFragmentByTag(fragTag) != null){
                Log.d(TAG, "applyFragment: Found frag with tag:"+ fragTag +"");
            }
            else{
                Log.d(TAG, "applyFragment: No frag with tag:"+ fragTag +"");
            }

            switch (fragTag){
                case FRAGMENT_ONE_TAG:
                    frag = mFragmentOne = FragmentOne.newInstance("FRAG_ONE");
                    break;
                case FRAGMENT_TWO_TAG:
                    //frag = mFragmentTwo = FragmentTwo.newInstance("FRAG_TWO");
                    frag = mFragmentTwo = FragmentFlutter.newInstance("FRAG_FLUTTER");
                    break;
            }
            mFragmentManager.beginTransaction()
                    .add(layoutId, frag, fragTag)
                    .commit();
        }
    }

    @Override
    public void onFrag1NavAwayClick() {
        Log.d(TAG, "onFrag1NavAwayClick: ");
        applyFragment(mFragmentTwo, R.id.layout_main_steps, FRAGMENT_TWO_TAG);
    }

    @Override
    public void onFrag2NavAwayClick() {
        Log.d(TAG, "onFrag2NavAwayClick: ");
        applyFragment(mFragmentOne, R.id.layout_main_steps, FRAGMENT_ONE_TAG);
    }

    @Override
    public void onFragFlutterNavAwayClick() {
        Log.d(TAG, "onFragFlutterNavAwayClick: ");
    }
}
