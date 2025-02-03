package com.duc.tradly.Onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duc.tradly.Home.sreens.HomeActivity
import com.duc.tradly.R

class OnboardActivity : AppCompatActivity() {
   private var currentStep=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn=findViewById<Button>(R.id.button)
        val description=findViewById<TextView>(R.id.description)
        val image=findViewById<ImageView>(R.id.imageView)
        val splashText1 = getString(R.string.splash1)
        val splashText2 = getString(R.string.splash2)
        val splashText3 = getString(R.string.splash3)
        description.text=splashText1
        image.setImageResource(R.drawable.group6)
        btn.setText("Next")
        btn.setOnClickListener {
            currentStep++  // Tăng bước hiện tại lên

            when (currentStep) {
                1 -> {
                    description.text = splashText2
                    image.setImageResource(R.drawable.group7)
                }
                2 -> {
                    description.text = splashText3
                    image.setImageResource(R.drawable.group8)
                    btn.setText("Finish")
                }
                3 -> {

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()  // Đảm bảo thoát khỏi OnboardActivity
                }
            }
        }

    }
}