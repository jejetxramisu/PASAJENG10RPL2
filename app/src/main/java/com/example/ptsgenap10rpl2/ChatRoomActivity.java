package com.example.ptsgenap10rpl2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatRoomActivity extends AppCompatActivity {

    private TextView tvName, tvChat;
    private ImageView imgProfile;
    private String name, chat;
    private int image;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        imgProfile = findViewById(R.id.image_chat);
        tvName = findViewById(R.id.tvName_chat);
        tvChat = findViewById(R.id.tvChat_chat);

        bundle = getIntent().getExtras();
        if (bundle !=  null) {
            image = bundle.getInt("image");
            name = bundle.getString("name");
            chat = bundle.getString("chat");

            imgProfile.setImageResource(image);
            tvName.setText(name);
            tvChat.setText(chat);
        }
    }
}