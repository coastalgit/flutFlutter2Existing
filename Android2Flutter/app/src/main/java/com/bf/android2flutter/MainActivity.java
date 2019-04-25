package com.bf.android2flutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class MainActivity extends AppCompatActivity {

    Button btnEmbed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GeneratedPluginRegistrant.registerWith(this);

        btnEmbed = findViewById(R.id.button_launchembed);
        btnEmbed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterActivity();
            }
        });
    }

    private void showFlutterActivity(){
        Intent intent = new Intent(this, EmbedTestActivity.class);
        startActivity(intent);
    }

}
