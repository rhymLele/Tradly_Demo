package com.duc.tradly.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Detail.Entities.Photo2
import com.duc.tradly.Home.Entities.Phantu
import com.duc.tradly.R

    class PhantuAdapter(private val mList:List<Phantu>)
        : RecyclerView.Adapter<PhantuAdapter.ViewHolder>() {
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val imageView: ImageView =itemView.findViewById(R.id.image_home_1)
            val title: TextView =itemView.findViewById(R.id.ptu_title)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_grid, parent, false)

            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return mList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val phantu: Phantu =mList[position]
            holder.imageView.setImageResource(phantu.resourceId)
            holder.title.setText(phantu.title)
        }
    }