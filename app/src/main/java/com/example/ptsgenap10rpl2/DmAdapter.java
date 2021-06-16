package com.example.ptsgenap10rpl2;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DmAdapter extends RecyclerView.Adapter<DmAdapter.ViewHolder> {

    private List<DmModelClass> userList;
    private OnItemClickListener mListener;
    private ChatActivity mContext;
    private int position;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public DmAdapter (ChatActivity mContext, List<DmModelClass>userList){
        this.mContext = mContext;
        this .userList=userList;
    }

    @NonNull
    @Override
    public DmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, mListener);
        ViewHolder holder = viewHolder;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int resource= userList.get(position) .getImageview1();
        String name= userList.get(position) .getTextview1();
        String msg= userList.get(position) .getTextview3();
        String time= userList.get(position) .getTextview2();
        String line= userList.get(position) .getDivider();

        holder.setData(resource,name,msg,time,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {


        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView2;
        private final TextView textView3;
        private final TextView divider;
        private final RelativeLayout rvLayout;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageview1);
            textView=itemView.findViewById(R.id.textview);
            textView2=itemView.findViewById(R.id.textview2);
            textView3=itemView.findViewById(R.id.textview3);
            divider=itemView.findViewById(R.id.divider);
            rvLayout=itemView.findViewById(R.id.rv_layout);
            rvLayout.setOnCreateContextMenuListener(this);

            rvLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void setData(int resource, String name, String msg, String time, String line) {

            imageView.setImageResource(resource);
            textView.setText(name);
            textView3.setText(msg);
            textView2.setText(time);
            divider.setText(line);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Delete = menu.add(Menu.NONE, 1, 1, "Delete");
            position = getAdapterPosition();
            Delete.setOnMenuItemClickListener(onEditMenu);

        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case 1:
                        userList.remove(position);
                        notifyDataSetChanged();
                        break;
                }
                return true;
            }
        };

    }
}
