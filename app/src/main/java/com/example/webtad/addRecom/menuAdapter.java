package com.example.webtad.addRecom;

import com.example.webtad.R;
import com.example.webtad.findWT.findData;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menuAdapter extends RecyclerView.Adapter<menuAdapter.ViewHolder> {

    Context mContext;
    ArrayList<findData> data;

    public menuAdapter(ArrayList<findData> data) {
        this.mContext = mContext;
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_btn,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thumbnail.setImageURI(Uri.parse(data.get(position).getThumbnail()));
        holder.title.setText(data.get(position).getTitle());
        holder.author.setText(data.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView title, author;
        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.title_rc);
            author=itemView.findViewById(R.id.author_rc);

        }
        /*
        public void setItem(Map<String, Object> item){

            thumbnail.setImageURI(Uri.parse(item.get("thumbnail").toString()));
            title.setText(item.get("title").toString());
            author.setText(item.get("author").toString());

        }*/
    }
}
