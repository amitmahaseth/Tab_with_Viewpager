package com.example.phonenumber

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phonenumber.adapter.ViewPagerAdapter
import com.example.phonenumber.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val animalsArray = arrayOf("ListNumber", "MessageList")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setupTabLayout()
    }

    fun setAdapter() {
        viewPagerAdapter = ViewPagerAdapter(this, 2)
        binding.Vp.adapter = viewPagerAdapter

    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabLayout, binding.Vp
        ) { tab, position -> tab.text = animalsArray[position] }.attach()
    }

    override fun onBackPressed() {
        val viewPager = binding.Vp
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }


}