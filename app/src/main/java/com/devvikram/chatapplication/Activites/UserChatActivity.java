package com.devvikram.chatapplication.Activites;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.devvikram.chatapplication.R;

public class UserChatActivity extends AppCompatActivity {

//    TextView name;
    Toolbar toolbar;
    ImageView profileImg;
    TextView username,usernumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chat);
//        name = findViewById(R.id.name);
        toolbar = findViewById(R.id.toolbar);
        profileImg = findViewById(R.id.userImg);
        username = findViewById(R.id.username);
        usernumber = findViewById(R.id.usernumber);


        String name = getIntent().getStringExtra("name");
        String num = getIntent().getStringExtra("number");
        String profile = getIntent().getStringExtra("profile");
        Log.d(TAG, "onCreate: "+profile);
        username.setText(name);
        usernumber.setText(num);
        profileImg.setImageResource(Integer.parseInt(profile));






        setSupportActionBar(toolbar);
    }
}