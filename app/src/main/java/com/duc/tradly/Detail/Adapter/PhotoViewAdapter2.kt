package com.duc.tradly.Detail.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Detail.Entities.Photo2
import com.duc.tradly.R

class PhotoViewAdapter2(private val mList:List<Photo2>)
    : RecyclerView.Adapter<PhotoViewAdapter2.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView:ImageView=itemView.findViewById(R.id.img_Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo2:Photo2=mList[position]
        holder.imageView.setImageResource(photo2.resourceId)
    }
}