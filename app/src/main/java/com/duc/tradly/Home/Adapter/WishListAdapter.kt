package com.duc.tradly.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Home.Entities.Product
import com.duc.tradly.R

class WishListAdapter (private val mList: List<Product>, private val onItemClick:(Product)->Unit,
                       private val onDeleteClick: (Product) -> Unit) :
    RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_product_img)
        val name: TextView = itemView.findViewById(R.id.tv_product_name)
        val price: TextView = itemView.findViewById(R.id.tv_product_price)
        val groceryName: TextView = itemView.findViewById(R.id.tv_product_gro)
        val imageViewIcon: ImageView = itemView.findViewById(R.id.img_icon_gro)
        val imgDel:ImageButton=itemView.findViewById(R.id.btn_del)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_wish, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = mList[position]
        holder.imageView.setImageResource(product.resourceId)
        holder.name.text = product.name
        holder.price.text = "$${product.price}"
        holder.groceryName.text = product.grocery.name
        holder.imageViewIcon.setImageResource(product.grocery.resourceIdIcon)
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
        holder.imgDel.setOnClickListener {
            // Gọi callback để xóa sản phẩm khỏi danh sách
            onDeleteClick(product)
        }

    }
}