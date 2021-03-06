package com.bf.android2flutter;

import android.os.Bundle;
import android.util.Log;

import io.flutter.app.FlutterActivity;
//import io.flutter.embedding.android.FlutterActivity;
import io.flutter.facade.Flutter;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterView;

public class MyFlutterActivity1 extends FlutterActivity {

    private static final String CHANNEL = "com.example.2flutter/comtest";

    MainApp mainApp;
    MethodChannel methodChannel;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Flutter.startInitialization(mainApp);

        super.onCreate(savedInstanceState);

        FlutterView.FirstFrameListener mListener = new FlutterView.FirstFrameListener() {
            @Override
            public void onFirstFrame() {
                Log.d("MyFlutterActivity1", "onFirstFrame triggered");
                //getFlutterView().pushRoute("/route2");
                getFlutterView().setInitialRoute("/route2");
            }
        };

        //getFlutterView().addFirstFrameListener(mListener);

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

    private String getMyNativeValue(){
        return "Hi from Android!";
    }
}
