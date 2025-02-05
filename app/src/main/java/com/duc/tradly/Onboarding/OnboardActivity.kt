package com.duc.tradly.Onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duc.tradly.Home.screens.HomeActivity
import com.duc.tradly.R

class OnboardActivity : AppCompatActivity() {
    private var currentStep = 0
    lateinit var btn: Button
    lateinit var description: TextView
    lateinit var image: ImageView
    lateinit var splashText1: String
    lateinit var splashText2: String
    lateinit var splashText3: String
    lateinit var dot1: View
    lateinit var dot2: View
    lateinit var dot3: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        anhxa()

        description.text = splashText1
        image.setImageResource(R.drawable.group6)
        btn.setText("Next")
        btn.setOnClickListener {
            currentStep++

            when (currentStep) {
                1 -> {
                    description.text = splashText2
                    image.setImageResource(R.drawable.group7)
                    updateDots(dot1,dot2,dot3,currentStep)
                }

                2 -> {
                    description.text = splashText3
                    image.setImageResource(R.drawable.group8)
                    btn.setText("Finish")
                    updateDots(dot1,dot2,dot3,currentStep)
                }

                3 -> {

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    onBoardingFinished()
                    finish()
                }
            }
        }

    }
    private fun onBoardingFinished(){
        val sharedPref=getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }
    fun anhxa() {
        btn = findViewById(R.id.button)
        description = findViewById(R.id.description)
        image = findViewById(R.id.imageView)
        splashText1 = getString(R.string.splash1)
        splashText2 = getString(R.string.splash2)
        splashText3 = getString(R.string.splash3)
        dot1=findViewById(R.id.dot1)
        dot2=findViewById(R.id.dot2)
        dot3=findViewById(R.id.dot3)
    }
    private fun updateDots(dot1: View, dot2: View, dot3: View, step: Int) {
        dot1.setBackgroundResource(if (step == 0) R.drawable.dot_selected else R.drawable.dot_unselected)
        dot2.setBackgroundResource(if (step == 1) R.drawable.dot_selected else R.drawable.dot_unselected)
        dot3.setBackgroundResource(if (step == 2) R.drawable.dot_selected else R.drawable.dot_unselected)
    }
}