package com.bf.android2flutter;

import io.flutter.app.FlutterApplication;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;

public class MainApp extends FlutterApplication {

/*
    private FlutterEngine flutterEngine;

    @Override
    public void onCreate() {
        super.onCreate();

        // Flutter must be initialized before FlutterEngines can be created.
        FlutterMain.startInitialization(this);
        FlutterMain.ensureInitializationComplete(this, new String[]{});

        // Instantiate a FlutterEngine.
        flutterEngine = new FlutterEngine(this);

        // Start running Dart code. This means that you need to select a Dart
        // entrypoint, and an initial route when you warm up your engine.
        DartExecutor.DartEntrypoint entrypoint = new DartExecutor.DartEntrypoint(
                getResources().getAssets(),
                FlutterMain.findAppBundlePath(this),
                "main"
        );
        flutterEngine.getDartExecutor().executeDartEntrypoint(entrypoint);
    }
*/

}
