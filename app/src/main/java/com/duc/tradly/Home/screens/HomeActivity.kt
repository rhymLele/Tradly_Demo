package com.duc.tradly.Home.screens

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.duc.tradly.Home.Adapter.GridAdapter
import com.duc.tradly.Home.Adapter.HomeViewPagerAdapter
import com.duc.tradly.Home.Adapter.ListGroceryAdapter
import com.duc.tradly.Home.Adapter.ListProductAdapter
import com.duc.tradly.Home.Adapter.PhantuAdapter
import com.duc.tradly.Home.Entities.GridItem
import com.duc.tradly.Home.Entities.Grocery
import com.duc.tradly.Home.Entities.Phantu
import com.duc.tradly.Home.Entities.Product
import com.duc.tradly.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        anhxa()
        val mViewPager2=findViewById<ViewPager2>(R.id.viewpager2_home)
        val mBottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_nav)
        val homeViewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager, lifecycle)
        mViewPager2.adapter = homeViewPagerAdapter
        mBottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_home -> mViewPager2.currentItem = 0
                R.id.bottom_browse -> mViewPager2.currentItem = 1
                R.id.bottom_store -> mViewPager2.currentItem = 2
                R.id.bottom_order -> mViewPager2.currentItem = 3
                R.id.bottom_profile -> mViewPager2.currentItem = 4
                else -> false
            }
            true
        }

        mViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mBottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
    }


//    private fun anhxa(): Unit {
//
//        val recyclerView: RecyclerView = findViewById(R.id.recycler_home_1)
//        val recyclerView2: RecyclerView = findViewById(R.id.recycler_home_2)
//        val recyclerView3: RecyclerView = findViewById(R.id.recycler_home_3)
//        val recyclerView4: RecyclerView = findViewById(R.id.recycler_home_4)
//        val recyclerGView: RecyclerView = findViewById(R.id.recycler_grid)
//
//        recyclerView.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView2.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView3.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView4.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//
//        val data = getPhanTu()
//        val phantuAdapter = PhantuAdapter(data)
//        recyclerView.adapter = phantuAdapter
//        val decor = object : DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL) {
//            override fun getItemOffsets(
//                outRect: Rect,
//                view: View,
//                parent: RecyclerView,
//                state: RecyclerView.State
//            ) {
//                super.getItemOffsets(outRect, view, parent, state)
//                outRect.right = 30 // Thêm khoảng cách giữa các phần tử
//            }
//        }
//
//        recyclerView.addItemDecoration(decor)
//        recyclerView2.addItemDecoration(decor)
//        recyclerView3.addItemDecoration(decor)
//        recyclerView4.addItemDecoration(decor)
//
//        val groceries = listOf(
//            Grocery(R.drawable.ava1, R.drawable.rec40, "Grocery 1"),
//            Grocery(R.drawable.avatar1, R.drawable.rec41, "Grocery 2"),
//            Grocery(R.drawable.ava1, R.drawable.rec41, "Grocery 3")
//        )
//        val products = listOf(
//            Product(R.drawable.pic1, "Product 1", 10.99, groceries[0]),
//            Product(R.drawable.shampoo, "Product 2", 20.99, groceries[1]),
//            Product(R.drawable.pic1, "Product 3", 20.99, groceries[2])
//        )
//        val dataList = listOf(
//            GridItem(R.drawable.rec28, "Beverages"),
//            GridItem(R.drawable.rec29, "Bread & Bakery"),
//            GridItem(R.drawable.rec30, "Vegetables"),
//            GridItem(R.drawable.rec31, "Fruit"),
//            GridItem(R.drawable.rec32, "Egg"),
//            GridItem(R.drawable.rec33, "Frozen veg"),
//            GridItem(R.drawable.rec34, "Homecare"),
//            GridItem(R.drawable.rec35, "Pet Care"),
//        )
//        val productAdapter = ListProductAdapter(products)
//        recyclerView2.adapter = productAdapter
//        recyclerView3.adapter = productAdapter
//
//
//        val groceryAdapter = ListGroceryAdapter(groceries)
//        recyclerView4.adapter = groceryAdapter
//
//
//// Thiết lập GridLayoutManager
//        val gridLayoutManager = GridLayoutManager(this, 4) // 4 cột
//        recyclerGView.layoutManager = gridLayoutManager
//
//// Gắn Adapter
//        val gridAdapter = GridAdapter(dataList)
//        recyclerGView.adapter = gridAdapter
//    }

    private fun getPhanTu(): List<Phantu> {
        val a = mutableListOf<Phantu>()
        a.add(Phantu(R.drawable.pic1, "ready for sure"))
        a.add(Phantu(R.drawable.pic1, "No ready "))
        a.add(Phantu(R.drawable.pic1, "syr"))
        return a
    }
}