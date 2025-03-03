package com.duc.tradly.Onboarding.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.duc.tradly.Home.screens.HomeActivity
import com.duc.tradly.R


class ThirdScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)
        val btn3=view.findViewById<Button>(R.id.button3)
        btn3.setOnClickListener {
//            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
            onBoardingFinished()
        }
        return view
    }

    private fun onBoardingFinished(){
        val sharedPref=requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }
}