package com.example.maverick;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class User_adapter extends RecyclerView.Adapter<User_adapter.UserViewHolder>{
    List list;
    Context context;
    CardView cardView;
    ArrayList<User> user;
    View view;


    public User_adapter(Context context, List list){
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public User_adapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_user,parent,false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull User_adapter.UserViewHolder holder, int position) {
       User user = (User) list.get(position);
       holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
        holder.username.setText(user.getUsername());
       // holder.sex.setText(user.getSex());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView email;
        TextView password;
        TextView phone;
        TextView username;
        TextView sex;
        TextView fullname;
        public UserViewHolder(@NonNull View itemView)  {
            super(itemView);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            username = itemView.findViewById(R.id.username);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
           itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Intent intent=new Intent(context,UserDetail.class);
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {

            int position = getAdapterPosition();
            ArrayList<User> u = new ArrayList<>();
            u.remove(u.get(position));
            User_adapter.this.notifyDataSetChanged();

            return false;
        }
    }
}
