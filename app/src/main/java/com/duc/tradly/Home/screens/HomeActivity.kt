package com.duc.tradly.Home.screens


import android.os.Build
import android.os.Bundle

import android.view.WindowMetrics
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.viewpager2.widget.ViewPager2

import com.duc.tradly.Home.Adapter.HomeViewPagerAdapter

import com.duc.tradly.R

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

import com.google.android.gms.ads.MobileAds

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    lateinit var  adView: AdView
    lateinit var frlayout: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_home)



        initUI()



    }
    private fun loadBanner() {
        val adView = AdView(this)
        adView.adUnitId = AD_UNIT_ID
        adView.setAdSize(adSize)
        this.adView = adView
        frlayout.removeAllViews()
        frlayout.addView(adView)
        // [END create_ad_view]

        // [START load_ad]
        // Start loading the ad in the background.
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        // [END load_ad]
    }
    private val adSize: AdSize
        get() {
            val displayMetrics = resources.displayMetrics
            val adWidthPixels =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val windowMetrics: WindowMetrics = this.windowManager.currentWindowMetrics
                    windowMetrics.bounds.width()
                } else {
                    displayMetrics.widthPixels
                }
            val density = displayMetrics.density
            val adWidth = (adWidthPixels / density).toInt()
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth)
        }
    companion object {
        // This is an ad unit ID for a test ad. Replace with your own banner ad unit ID.
        private const val AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"
    }
    fun initUI(){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mViewPager2=findViewById<ViewPager2>(R.id.viewpager2_home)
        val mBottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_nav)
        val homeViewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager, lifecycle)
        mViewPager2.adapter = homeViewPagerAdapter
        frlayout=findViewById(R.id.ad_view_container)
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
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@HomeActivity) {
                runOnUiThread {
                    loadBanner()
//                    appOpenAdManager = AppOpenAdManager()
                }
            }
        }
    }
}