package com.duc.tradly.Onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.duc.tradly.R


class SecondScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)
        val btn2=view.findViewById<Button>(R.id.button2)
        val viewPager=activity?.findViewById<ViewPager2>(R.id.viewPager)
        btn2.setOnClickListener {
            viewPager?.currentItem=2
        }
        return view
    }


}