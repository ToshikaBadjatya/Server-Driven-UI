package com.example.xml.helpers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.xml.screens.SingleScreenFragment

class TabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,): FragmentStateAdapter(fragmentManager,lifecycle,) {
   val list=mutableListOf<SingleScreenFragment>()
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun submitFragList(frags: List<SingleScreenFragment>){
        list.clear()
        list.addAll(frags)
    }
}