package com.bf.android2flutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEmbed, btnEmbed2;
    Button btnFlutterActivity1, btnFlutterFrag1;

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

        btnFlutterActivity1 = findViewById(R.id.button_launchfa1);
        btnFlutterActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterActivity1();
            }
        });

        btnFlutterFrag1 = findViewById(R.id.button_launchfrag1);
        btnFlutterFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFlutterFrag1();
            }
        });

    }

    private void showFlutterEmbedded(){
        Intent intent = new Intent(this, EmbedTest1Activity.class);
        startActivity(intent);
    }

    private void showFlutterEmbeddedWithEventChannel() {
        Intent intent = new Intent(this, EmbedTest2Activity.class);
        startActivity(intent);
    }

    private void showFlutterActivity1(){
        Intent intent = new Intent(this, MyFlutterActivity1.class);
        startActivity(intent);
    }

/*
    private void showFlutterFrag1(){
//        Intent intent = new Intent(this, MyFlutterFrag1.class);
//        startActivity(intent);
        Intent flutterIntent = new MyFlutterFrag1.IntentBuilder().initialRoute("route3").build(MainActivity.this);
        startActivity(flutterIntent);
    }
*/

    private void showFlutterFrag1(){
        Intent recipeIntent = new Intent(this, MainFragActivity.class);
        //recipeIntent.putExtra(RecipeActivity.KEY_RECIPE, recipe);
        startActivity(recipeIntent);
    }

}
