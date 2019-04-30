package com.bf.android2flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;


public class MyFlutterFrag1 extends FlutterActivity implements FlutterFragment.FlutterEngineProvider {

    private static final String TAG = "MyFlutterFrag1";
    //private static final String CHANNEL = "com.example.2flutter/comtest";

    private static final String EVENT_CHANNEL = "com.example.2flutter/comtest";

    public static Intent createDefaultIntent(@NonNull Context launchingContext) {
        return new IntentBuilder().build(launchingContext);
    }

    @Nullable
    @Override
    public FlutterEngine getFlutterEngine(@NonNull Context context) {
        return FlutterCachedEngine.getInstance(getApplicationContext());
    }

    protected static class IntentBuilder extends FlutterActivity.IntentBuilder {
        // Override the constructor to specify your class.
        IntentBuilder() {
            super(MyFlutterFrag1.class);
        }
    }

    EventChannel eventChannel;
    MethodChannel methodChannel;
    //FlutterView flutterView;


//    @Override
//    public FlutterView getFlutterView() {
//        return super.getFlutterView();
//    }


//    @Override
//    public FlutterView createFlutterView(Context context) {
//        FlutterNativeView fnv = this.createFlutterNativeView();
//
//        WindowManager.LayoutParams matchParent = new WindowManager.LayoutParams(-1, -1);
//        FlutterNativeView nativeView = this.createFlutterNativeView();
//        FlutterView flutterView = new FlutterView(this, (AttributeSet) null, nativeView);
//        flutterView.setInitialRoute("/dashboard");
//        flutterView.setLayoutParams(matchParent);
//        this.setContentView(flutterView);
//        return flutterView;
//        //return super.createFlutterView(context);
//    }


/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        //Flutter.startInitialization(mainApp);
        super.onCreate(savedInstanceState);

*/
/*
        FlutterView.FirstFrameListener mListener = new FlutterView.FirstFrameListener() {
            @Override
            public void onFirstFrame() {
                Log.d("MyFlutterFrag1", "onFirstFrame triggered");
                //getFlutterView().pushRoute("/route2");
                getFlutterView().setInitialRoute("/route2");
            }
        };

        getFlutterView().addFirstFrameListener(mListener);
*//*



        GeneratedPluginRegistrant.registerWith(this);
        methodChannel = new MethodChannel(getFlutterView(), CHANNEL);
        methodChannel.setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                        if (call.method.equals("getNativeMessage")) {
                            String nativeMsg = getMyNativeValue();
//                            else
//                                result.error("UNAVAILABLE", "msg not available.", null);
                            result.success(nativeMsg);
                        } else {
                            result.notImplemented();
                        }
                    }
                });

    }
*/

    private String getMyNativeValue(){
        return "Hi from Android!";
    }

}
