package com.bf.android2flutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEmbed;
    Button btnFlutterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GeneratedPluginRegistrant.registerWith(this);

        btnEmbed = findViewById(R.id.button_launchembed);
        btnEmbed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterEmbedded();
            }
        });

        btnFlutterActivity = findViewById(R.id.button_launchfa);
        btnFlutterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterActivity();
            }
        });

    }

    private void showFlutterEmbedded(){
        Intent intent = new Intent(this, EmbedTestActivity.class);
        startActivity(intent);
    }

    private void showFlutterActivity(){
        Intent intent = new Intent(this, MyFlutterActivity.class);
        startActivity(intent);
    }

}
