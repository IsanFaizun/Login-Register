package com.example.tugas8

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tugas8.databinding.ActivityValidationBinding
import com.google.android.material.tabs.TabLayoutMediator

class ValidationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValidationBinding
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.action_bar)

        binding = ActivityValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewPager.adapter = TabAdapter(this@ValidationActivity)
            viewPager2 = viewPager

            TabLayoutMediator(tabLayout, viewPager) {
                    tab, position ->
                tab.text = when(position) {
                    0 -> "Register"
                    1 -> "Login"
                    else -> ""
                }
            }.attach()
        }
    }
    fun navigateToLoginPage() {
        viewPager2.setCurrentItem(1, true)
    }
    fun navigateToRegisterPage() {
        viewPager2.setCurrentItem(0, true)
    }
}