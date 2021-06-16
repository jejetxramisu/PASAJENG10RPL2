package com.example.ptsgenap10rpl2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    androidx.recyclerview.widget.RecyclerView recyclerView;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    List<DmModelClass>userList;
    DmAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);

        registerForContextMenu(recyclerView);

        initData();
        initRecyclerView();



    }

    private void initData() {

        userList = new ArrayList<>();

        String textview1;
        String textview2;
        String textview3;
        String divider;

        userList.add(new DmModelClass(R.drawable.cowo1, "Febrian", "11.45Pm", "bb,wht r u doing?", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.girl2, "Adel", "10.45Pm", "up to you", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.cowo1, "Febrian", "9.45Pm", "lets meet", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.cowo2, "Gama", "9.32Pm", "its ok,im fine", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.girl, "Vania", "9.18Am", "hahaha, so funny", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.girl2, "Adel", "8.12Am", "buy me icecream", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.cowo1, "Febrian", "7.45Am", "oke bb", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.cowo2, "Gama", "7.22Am", "oke, i see", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.girl, "Vania", "7.12Am", "can you help me", "--------------------------------------------------------------------"));
        userList.add(new DmModelClass(R.drawable.girl2, "Adel", "6.45Am", "hy gurl-!", "--------------------------------------------------------------------"));

    }

    private void initRecyclerView() {

        Adapter = new DmAdapter(ChatActivity.this, userList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(Adapter);

        Adapter.setOnItemClickListener(new DmAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), ChatRoomActivity.class);
                intent.putExtra("image", userList.get(position).getImageview1());
                intent.putExtra("name", userList.get(position).getTextview1());
                intent.putExtra("chat", userList.get(position).getTextview3());
                startActivity(intent);
            }
        });
    }
}