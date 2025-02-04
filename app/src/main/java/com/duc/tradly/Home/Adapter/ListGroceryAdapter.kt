package com.duc.tradly.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Home.Entities.Grocery
import com.duc.tradly.R

class ListGroceryAdapter(private val mList: List<Grocery>) : RecyclerView.Adapter<ListGroceryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_grocery_img)
        val imageViewIcon: ImageView = itemView.findViewById(R.id.img_icon_gro)
        val name: TextView = itemView.findViewById(R.id.tv_grocery_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grocery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grocery = mList[position]
        holder.imageView.setImageResource(grocery.resourceId)
        holder.imageViewIcon.setImageResource(grocery.resourceIdIcon)
        holder.name.text = grocery.name
    }
}
