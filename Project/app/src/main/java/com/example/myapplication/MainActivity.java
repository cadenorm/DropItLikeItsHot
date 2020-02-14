package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView2);
        Button button = findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //textView.setText("Sorry, this button doesn't do anything yet!");
                setContentView(R.layout.game);
                hideAllBlocks();
            }
        });
    }

    void hideAllBlocks() {
        ImageView img = findViewById(R.id.b49);
        img.setColorFilter(Color.argb(255, 255, 0, 0));
    }
}
