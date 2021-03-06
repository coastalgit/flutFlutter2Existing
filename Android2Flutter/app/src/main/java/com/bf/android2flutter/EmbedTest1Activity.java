package com.bf.android2flutter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class EmbedTest1Activity extends AppCompatActivity {

    View flutterView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embed_test);

        //GeneratedPluginRegistrant.registerWith(this);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFlutterView();
            }
        });
    }

    @Override
    protected void onDestroy() {
        //flutterView = null;
        super.onDestroy();
    }

    private void createFlutterView(){
/*
        View flutterView = Flutter.createView(MainActivity.this, getLifecycle(), "route1");
        FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        frameLayout.topMargin = 200;
        addContentView(flutterView, frameLayout);
*/
        flutterView = Flutter.createView(EmbedTest1Activity.this, getLifecycle(), "route1");
        FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        frameLayout.topMargin = 200;
        addContentView(flutterView, frameLayout);

    }

}
