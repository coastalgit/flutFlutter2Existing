package com.bf.android2flutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEmbed, btnEmbed2;
    Button btnFlutterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GeneratedPluginRegistrant.registerWith(this);

        btnEmbed = findViewById(R.id.button_launchembed1);
        btnEmbed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterEmbedded();
            }
        });

        btnEmbed2 = findViewById(R.id.button_launchembed2);
        btnEmbed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterEmbeddedWithEventChannel();
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

    private void showFlutterEmbeddedWithEventChannel() {
        Intent intent = new Intent(this, EmbedTest2Activity.class);
        startActivity(intent);
    }

    private void showFlutterActivity(){
        Intent intent = new Intent(this, MyFlutterActivity.class);
        startActivity(intent);
    }

}
