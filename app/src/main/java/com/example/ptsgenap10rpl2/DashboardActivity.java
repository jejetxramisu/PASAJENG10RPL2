package com.example.ptsgenap10rpl2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.view.View.*;

public class DashboardActivity extends AppCompatActivity {
    CardView cardview_directMessage;
    ChatActivity chatActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cardview_directMessage = findViewById(R.id.cardvie_directMessage);
        cardview_directMessage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(DashboardActivity.this , ChatActivity.class);
                startActivity(move);
            }
        });
            }
        }
