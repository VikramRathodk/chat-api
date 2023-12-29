package com.devvikram.chatapplication.Adapters;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.devvikram.chatapplication.Activites.UserChatActivity;
import com.devvikram.chatapplication.R;
import com.devvikram.chatapplication.Models.UserModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.viewHolder>{
    Context context;
    List<UserModel> chatUsers ;

    public ChatAdapter(Context context, List<UserModel> chatUsers) {
        this.context = context;
        this.chatUsers = chatUsers;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.chat_card,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        UserModel chatuser = chatUsers.get(position);

            holder.userImage.setImageResource(chatuser.getImg());
            holder.username.setText(chatuser.getName());
            holder.usernumber.setText(chatuser.getNumber());

            holder.chatCard.setOnClickListener(v -> {
                Toast.makeText(context.getApplicationContext(),"clicked on",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(context.getApplicationContext(), UserChatActivity.class);
                intent.putExtra("name",chatuser.getName());
                intent.putExtra("number",chatuser.getNumber());
                String image = String.valueOf(chatuser.getImg());
                intent.putExtra("profile",image);
                Log.d(TAG, "onBindViewHolder: "+image);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);



            });

    }

    @Override
    public int getItemCount() {
        return chatUsers.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView username,usernumber;
        CardView chatCard;
        public viewHolder(@NonNull View itemView) {

            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.username);
            usernumber = itemView.findViewById(R.id.usernumber);
            chatCard = itemView.findViewById(R.id.chatCard);

        }
    }
}
