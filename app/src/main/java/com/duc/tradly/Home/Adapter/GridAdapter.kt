package com.duc.tradly.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Home.Entities.GridItem
import com.duc.tradly.R

class GridAdapter (
    private val itemList: List<GridItem>
) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    // ViewHolder đại diện cho mỗi item trong grid
    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val label: TextView = view.findViewById(R.id.label)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item = itemList[position]
        holder.icon.setImageResource(item.iconResId)
        holder.label.text = item.label

        // Xử lý sự kiện click (nếu cần)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicked: ${item.label}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = itemList.size
}