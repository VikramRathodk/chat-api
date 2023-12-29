package com.devvikram.chatapplication.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.devvikram.chatapplication.R;

public class MainActivity extends AppCompatActivity {
    Button moveToChat,fetchBtn;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);


        moveToChat = findViewById(R.id.moveToChat);
        fetchBtn = findViewById(R.id.fetchBtn);
        moveToChat.setOnClickListener((view)->{
            startActivity(new Intent(MainActivity.this,ChatActivity.class));
        });
        fetchBtn.setOnClickListener((view)->{
            startActivity(new Intent(MainActivity.this,ProductsActivity.class));
        });


      setSupportActionBar(toolbar);
    }
}