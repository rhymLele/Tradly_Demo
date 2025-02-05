package com.duc.tradly.Home.screens

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.CartManager
import com.duc.tradly.Detail.DetailActivity
import com.duc.tradly.GridSpacingItemDecoration
import com.duc.tradly.Home.Adapter.WishListAdapter
import com.duc.tradly.Home.Entities.Grocery
import com.duc.tradly.Home.Entities.Product
import com.duc.tradly.Home.Entities.WishList
import com.duc.tradly.R

class WishListActivity : AppCompatActivity() {
    private lateinit var adapter: WishListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wish_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val back=findViewById<ImageButton>(R.id.btn_back)
        back.setOnClickListener {
            finish()
        }



        val recyclerView = findViewById<RecyclerView>(R.id.recycler_wishList)


        recyclerView.layoutManager = GridLayoutManager(this,2)


        adapter = WishListAdapter(CartManager.cart.getProducts(), { selectedProduct ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_data", selectedProduct)
            startActivity(intent)
        },{ productToDelete ->
            val position = CartManager.cart.getProducts().indexOf(productToDelete)
            if (position != -1) {
//                CartManager.cart.removeProduct(productToDelete)
//                adapter.notifyItemRemoved(position)
                val sharedPreferences = getSharedPreferences("WishListPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alert Dialog")
                    .setMessage("Do you want to delete")
                    .setPositiveButton("OK") { dialog, _ ->
                        CartManager.cart.removeProduct(productToDelete)
                        adapter.notifyItemRemoved(position)


                        editor.putBoolean("isProductInWishList", false)
                        editor.apply()

                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->

                        editor.putBoolean("isProductInWishList", true)
                        editor.apply()

                        dialog.dismiss()

                        dialog.dismiss()
                    }
                    .show()
            }
        })
        recyclerView.adapter = adapter
    }
}