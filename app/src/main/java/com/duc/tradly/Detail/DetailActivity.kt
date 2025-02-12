package com.duc.tradly.Detail

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.duc.tradly.CartManager
import com.duc.tradly.Detail.Adapter.PhotoViewAdapter2
import com.duc.tradly.Detail.Entities.Photo2
import com.duc.tradly.Home.Entities.Product
import com.duc.tradly.Home.screens.WishListActivity

import com.duc.tradly.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import me.relex.circleindicator.CircleIndicator3

class DetailActivity : AppCompatActivity() {
    lateinit var btn_Wish:ImageButton
    val chuoi:String="Remove Cart"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom)
            insets
        }

        val btn_back=findViewById<ImageButton>(R.id.btn_back)
        val btn_add=findViewById<Button>(R.id.add_to_cart_button)
        val originalPrice = findViewById<TextView>(R.id.original_price)
        val product = intent.getSerializableExtra("product_data") as? Product
        btn_Wish=findViewById(R.id.icon2)
        btn_Wish.setOnClickListener {
            val intent= Intent(this, WishListActivity::class.java)
            startActivity(intent)
        }


        originalPrice.paintFlags = originalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG


        if (product != null) {

            val nameTextView: TextView = findViewById(R.id.tv_product_detail_name)
            val priceTextView: TextView = findViewById(R.id.tv_product_detail_price)
            val groceryNameTextView: TextView = findViewById(R.id.tv_product_detail_gro)
            val iconGrocery: ImageView = findViewById(R.id.img_detail_icon_gro)
            nameTextView.text = product.name
            priceTextView.text = "$${product.price}"
            groceryNameTextView.text = product.grocery.name
            iconGrocery.setImageResource(product.grocery.resourceIdIcon)
            if(CartManager.cart.contains(product))
            {
                btn_add.text = "Remove Cart"
                btn_Wish.setImageResource(R.drawable.baseline_heart_broken_24v32)
            }
            else{
                btn_add.text = "Add to Cart"
                btn_Wish.setImageResource(R.drawable.baseline_heart_broken_24)
            }
        }

        btn_add.setOnClickListener {
            if (product != null) {
                CartManager.cart.addProduct(product = product)
                btn_Wish.setImageResource(R.drawable.baseline_heart_broken_24v32)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alert Dialog")
                    .setMessage("Added in Wishlist.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss() // Đóng hộp thoại khi nhấn "OK"
                    }
                    .show()
            } else {

                Log.e("DetailActivity", "Product is null")
            }
        }
        btn_back.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","dang here")
        val sharedPreferences = getSharedPreferences("WishListPrefs", MODE_PRIVATE)
        val isProductInWishList = sharedPreferences.getBoolean("isProductInWishList", true)

        if (isProductInWishList) {
            btn_Wish.setImageResource(R.drawable.baseline_heart_broken_24v32)
        } else {
            btn_Wish.setImageResource(R.drawable.baseline_heart_broken_24)  // Chuyển icon thành màu trắng
        }
    }
}