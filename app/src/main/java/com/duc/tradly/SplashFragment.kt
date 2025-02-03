package com.duc.tradly

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.duc.tradly.Home.sreens.HomeActivity
import com.duc.tradly.Onboarding.OnboardActivity

class SplashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            if(onBoardingFinished()){
//                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                // Kết thúc SplashFragment (nếu không muốn quay lại)
                requireActivity().finish()
            }else{
//                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
                val intent = Intent(requireContext(), OnboardActivity::class.java)
                startActivity(intent)
                // Kết thúc SplashFragment (nếu không muốn quay lại)
                requireActivity().finish()
            }
        }, 3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }


}