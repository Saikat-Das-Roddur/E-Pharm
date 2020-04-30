package com.saikat.e_pharm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saikat.e_pharm.Model.Blog;
import com.saikat.e_pharm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.Holder> {

    Context context;
    List<Blog> blogList = new ArrayList<>();

    public BlogAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public BlogAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.rv_blog,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.Holder holder, int position) {
        position = position%blogList.size();
        Picasso.get().load(blogList.get(position).getImage()).into(holder.imageViewBlog);
        holder.textViewTitle.setText(blogList.get(position).getTitle());
        holder.textViewDescription.setText(blogList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public void setBlogList(ArrayList<Blog> blogArrayList) {
        this.blogList = blogArrayList;
        notifyDataSetChanged();
    }

    public void addAllBlogList(ArrayList<Blog> blogArrayList) {
        this.blogList.addAll(blogArrayList);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageViewBlog;
        TextView textViewTitle,textViewDescription;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageViewBlog = itemView.findViewById(R.id.blogIv);
            textViewTitle = itemView.findViewById(R.id.titleTv);
            textViewDescription = itemView.findViewById(R.id.descriptionTv);
        }
    }
}
