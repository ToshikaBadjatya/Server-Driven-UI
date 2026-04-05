package com.example.xml.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.xml.R
import com.example.xml.helpers.TabAdapter
import org.json.JSONArray
import org.json.JSONObject

private const val JSON_OBJECT = "json_object"

class MultiScreenFragment : BaseFragment() {

    private var jsonString: String? = null
    private lateinit var viewPager: ViewPager2
    private lateinit var tabAdapter: TabAdapter

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
        val pageList=mutableListOf<SingleScreenFragment>()
        try {
            val jsonArray= JSONArray(jsonString)
            for(i in 0 until jsonArray.length()){
                val ele=jsonArray.get(i)
                when(ele){
                    is JSONObject->{
                        val frag=SingleScreenFragment.newInstance(ele.toString())
                       pageList.add(frag)
                    }
                    else->{

                    }
                }
            }
        }catch (e: Exception){

        }
        tabAdapter = TabAdapter(childFragmentManager, lifecycle)
        tabAdapter.submitFragList(pageList)
        viewPager.adapter = tabAdapter
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
