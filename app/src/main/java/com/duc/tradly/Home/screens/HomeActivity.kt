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
}