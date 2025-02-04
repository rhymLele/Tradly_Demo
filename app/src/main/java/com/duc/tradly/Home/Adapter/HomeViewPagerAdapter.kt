package com.duc.tradly.Home.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.duc.tradly.Home.Fragment.BrowseFragment
import com.duc.tradly.Home.Fragment.HomeFragment
import com.duc.tradly.Home.Fragment.OrderFragment
import com.duc.tradly.Home.Fragment.ProfileFragment
import com.duc.tradly.Home.Fragment.StoreFragment

class HomeViewPagerAdapter(
    fm: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 5 // Số lượng fragment
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> BrowseFragment()
            2 -> StoreFragment()
            3 -> OrderFragment()
            4 -> ProfileFragment()
            else -> HomeFragment() // Trường hợp mặc định
        }
    }
}