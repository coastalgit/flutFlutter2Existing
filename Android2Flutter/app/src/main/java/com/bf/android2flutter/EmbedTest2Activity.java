package com.bf.android2flutter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import io.flutter.facade.Flutter;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
//import io.flutter.embedding.android.FlutterView;
import io.flutter.view.FlutterView;

/*
* This example uses a BasicMessageChannel to send string (to Flutter view) and process a received string (from a Flutter view)
*/

public class EmbedTest2Activity extends AppCompatActivity {

    private static final String CHANNEL = "com.example.2flutter/comtestevent";
    private BasicMessageChannel<String> messageChannel;

    FlutterView flutterView;
    Button btn1, btn2;
    FrameLayout frameFlutter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embed_test2);

        frameFlutter = findViewById(R.id.frame_flutter);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFlutterView();
            }
        });

        // Using Java 8 so Lambdas are go :)
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(view -> sendMsgToFlutter("Hi from Android Activity"));
        btn2.setEnabled(false);

    }

    @Override
    protected void onDestroy() {
        if (flutterView != null) {
            flutterView.destroy();
        }
        super.onDestroy();
    }

    private void sendMsgToFlutter(String msg) {
        if (messageChannel != null){
            messageChannel.send(msg);
        }
    }

    private void createFlutterView(){
        flutterView = Flutter.createView(EmbedTest2Activity.this, getLifecycle(), "route2");

        messageChannel = new BasicMessageChannel<>(flutterView, CHANNEL, StringCodec.INSTANCE);
        //messageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler<String>() {
        //@Override
        //public void onMessage(String s, BasicMessageChannel.Reply<String> reply) {...
        messageChannel.setMessageHandler((s, reply) -> {
                String rcd = "RCD:["+s+"]";
                Log.d("EmbedTest2Activity", rcd);
                Toast.makeText(EmbedTest2Activity.this, rcd, Toast.LENGTH_SHORT).show();
                //reply.reply("Thanks from Android");
            });
        //FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //frameLayout.topMargin = 350;
        //addContentView(flutterView, frameLayout);

        frameFlutter.addView(flutterView);

        btn1.setEnabled(false);
        btn2.setEnabled(true);
    }

}
