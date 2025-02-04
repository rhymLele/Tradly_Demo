package com.duc.tradly.Detail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duc.tradly.Detail.Entities.Photo;
import com.duc.tradly.R;

import java.util.List;

public class PhotoViewPagerAdapter extends RecyclerView.Adapter<PhotoViewPagerAdapter.PhotoViewHolder>{
    List<Photo> imageViewList;

    public PhotoViewPagerAdapter(List<Photo> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo imageView=imageViewList.get(position);
        if(imageView==null) return;
        holder.imgPhoto.setImageResource(imageView.getResourceId());
    }

    @Override
    public int getItemCount() {
        return imageViewList!=null?imageViewList.size():0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPhoto;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.img_Product);
        }
    }
}
