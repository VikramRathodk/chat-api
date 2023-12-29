package com.devvikram.chatapplication.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.devvikram.chatapplication.Adapters.ChatAdapter;
import com.devvikram.chatapplication.R;
import com.devvikram.chatapplication.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    RecyclerView chatRecyclerView;
    List<UserModel> chatUsers = new ArrayList<>();
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatRecyclerView = findViewById(R.id.chatRecycler);
        toolbar = findViewById(R.id.toolbar);

        //Add users

        chatUsers.add(new UserModel("1","Ironman", android.R.drawable.ic_dialog_map,"4874754874"));
        chatUsers.add(new UserModel("2","Captain America", android.R.drawable.ic_dialog_alert,"4874754874"));
        chatUsers.add(new UserModel("3","Thor Odinson", android.R.drawable.ic_btn_speak_now,"4874754874"));
        chatUsers.add(new UserModel("4","Wanda", android.R.drawable.ic_dialog_email,"4874754874"));
        chatUsers.add(new UserModel("5","Vision", android.R.drawable.ic_input_get,"4874754874"));
        chatUsers.add(new UserModel("6","client", android.R.drawable.ic_dialog_info,"87457455845"));


        chatRecyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));

        ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(),chatUsers);
        chatRecyclerView.setAdapter(chatAdapter);

        setSupportActionBar(toolbar);
    }


}