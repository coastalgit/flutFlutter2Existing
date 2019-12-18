package com.bf.android2flutter;

import android.content.Context;
import android.support.annotation.NonNull;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterMain;


/*
 * @author frielb
 * Created on 29/04/2019
 */
public class FlutterCachedEngine{

    private static FlutterEngine instance = null;

    public FlutterCachedEngine() {
        //
    }

    private synchronized static void createInstance(Context appContext){
        if (instance == null){
            FlutterMain.startInitialization(appContext);
            //FlutterMain.ensureInitializationComplete(appContext, arra);
            instance = new FlutterEngine(appContext);
        }
    }

    public static FlutterEngine getInstance(Context appContext){
        if (instance == null)
            createInstance(appContext);
        return instance;
    }
}
