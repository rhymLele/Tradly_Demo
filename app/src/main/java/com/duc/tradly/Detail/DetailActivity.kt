package com.duc.tradly.Detail

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.duc.tradly.Detail.Adapter.PhotoViewAdapter2
import com.duc.tradly.Detail.Entities.Photo2
import com.duc.tradly.Home.Entities.Product

import com.duc.tradly.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import me.relex.circleindicator.CircleIndicator3

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom)
            insets
        }
//        val bottomSheet = findViewById<View>(R.id.bottom_sheet)
//        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
//
//        bottomSheetBehavior.peekHeight = 300
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//        val bt=findViewById<Button>(R.id.btn_keolen)
//        bottomSheetBehavior.addBottomSheetCallback(object :
//            BottomSheetBehavior.BottomSheetCallback() {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                // Không cần xử lý gì ở đây nếu chỉ giới hạn chiều cao
//                when (newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> {
//                        bottomSheetBehavior.peekHeight = 300
//                        Log.d("height",bottomSheetBehavior.state.toString())
//                        bt.visibility=View.VISIBLE
//                    }
//
//                    BottomSheetBehavior.STATE_EXPANDED -> {
//                        bt.visibility=View.INVISIBLE
//                        bottomSheetBehavior.maxHeight = 600
//                        Log.d("height1",bottomSheetBehavior.state.toString())
//                    }
//                }
//            }
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//            }
//        })
//
//        val mViewPager2:ViewPager2
//        val mCircleIndicator3:CircleIndicator3
        val btn_back=findViewById<ImageButton>(R.id.btn_back)
//        mViewPager2=findViewById(R.id.view_pager2)
//        mCircleIndicator3=findViewById(R.id.circle_indicator)
        val data =getListPhoto()
        val photoViewPagerAdapter= PhotoViewAdapter2(data)
//        mViewPager2.adapter=photoViewPagerAdapter
//        mCircleIndicator3.setViewPager(mViewPager2)
        val originalPrice = findViewById<TextView>(R.id.original_price)
        originalPrice.paintFlags = originalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        val product = intent.getSerializableExtra("product_data") as? Product
        if (product != null) {

            val nameTextView: TextView = findViewById(R.id.tv_product_detail_name)
            val priceTextView: TextView = findViewById(R.id.tv_product_detail_price)
            val groceryNameTextView: TextView = findViewById(R.id.tv_product_detail_gro)
            val iconGrocery: ImageView = findViewById(R.id.img_detail_icon_gro)
            nameTextView.text = product.name
            priceTextView.text = "$${product.price}"
            groceryNameTextView.text = product.grocery.name
            iconGrocery.setImageResource(product.grocery.resourceIdIcon)
        }

        btn_back.setOnClickListener {
            finish()
        }
    }
    private fun getListPhoto(): List<Photo2> {
        val a = mutableListOf<Photo2>()
        a.add(Photo2(R.drawable.pic1))
        a.add(Photo2(R.drawable.pic1))
        a.add(Photo2(R.drawable.pic1))
        return a
    }
}