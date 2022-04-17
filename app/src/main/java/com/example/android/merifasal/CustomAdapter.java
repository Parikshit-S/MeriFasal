package com.example.android.merifasal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.merifasal.content.ContentActivity;
import com.example.android.merifasal.content.ContentActivity2;
import com.example.android.merifasal.content.ContentActivity3;
import com.example.android.merifasal.content.ContentActivity4;
import com.example.android.merifasal.content.ContentActivity5;
import com.example.android.merifasal.content.ContentActivity6;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<ModelClass> mlist;
    Context context;

    public CustomAdapter(List<ModelClass> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.layout_file, parent, false);


        return new MyViewHolder(view);
    }

    private void filterList(List<ModelClass> filterList) {
        mlist = filterList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ModelClass temp = mlist.get(position);

        holder.imageView.setImageResource(mlist.get(position).getImage());
        holder.textView.setText(mlist.get(position).getText());

        switch (position) {
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;

            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity2.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity2.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;

            case 2:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity3.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity3.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;

            case 3:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity4.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity4.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;

            case 4:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity5.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity5.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;

            case 5:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity6.class);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ContentActivity6.class);
                        v.getContext().startActivity(intent);
                    }
                });
                break;



            default:


        }


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.layoutImageId);
            textView= itemView.findViewById(R.id.nameTextViewId);

        }
    }
}
