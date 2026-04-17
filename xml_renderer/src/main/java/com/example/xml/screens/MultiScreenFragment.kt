package com.example.xml.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.xml.R
import com.example.xml.helpers.PageNavigationListener
import com.example.xml.helpers.TabAdapter
import org.json.JSONArray
import org.json.JSONObject

private const val JSON_OBJECT = "json_object"

class MultiScreenFragment : BaseFragment(), PageNavigationListener {

    private var jsonString: String? = null
    private lateinit var viewPager: ViewPager2
    private lateinit var tabAdapter: TabAdapter
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            jsonString = it.getString(JSON_OBJECT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_multi_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        btnPrev = view.findViewById(R.id.btnPrev)
        btnNext = view.findViewById(R.id.btnNext)

        val pageList = mutableListOf<SingleScreenFragment>()
        try {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val ele = jsonArray.get(i)
                when (ele) {
                    is JSONObject -> pageList.add(SingleScreenFragment.newInstance(ele.toString()))
                    else -> {}
                }
            }
        } catch (e: Exception) {
            Log.e("multi", "Failed to parse json: ${e.message}")
        }

        tabAdapter = TabAdapter(childFragmentManager, lifecycle, this)
        tabAdapter.submitFragList(pageList)
        viewPager.adapter = tabAdapter
        Log.e("multi", "opened multi frag ${pageList.size}")

        updateButtonStates()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateButtonStates()
            }
        })

        btnPrev.setOnClickListener { goPrev() }
        btnNext.setOnClickListener { goNext() }
    }

    override fun goNext() {
        val next = viewPager.currentItem + 1
        if (next < tabAdapter.itemCount) {
            viewPager.currentItem = next
        }
    }

    override fun goPrev() {
        val prev = viewPager.currentItem - 1
        if (prev >= 0) {
            viewPager.currentItem = prev
        }
    }

    private fun updateButtonStates() {
        val current = viewPager.currentItem
        btnPrev.isEnabled = current > 0
        btnNext.isEnabled = current < tabAdapter.itemCount - 1
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            MultiScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(JSON_OBJECT, param1)
                }
            }
    }
}
