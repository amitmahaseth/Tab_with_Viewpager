package com.example.phonenumber.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.phonenumber.fragment.ListNumberFragment
import com.example.phonenumber.fragment.MessageFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return totalCount
    }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListNumberFragment()
            1 -> MessageFragment()
            else -> ListNumberFragment()
        }


    }
}