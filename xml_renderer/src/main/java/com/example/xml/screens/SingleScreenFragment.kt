package com.example.xml.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xml.R


private const val JSON_OBJECT = "json_object"


class SingleScreenFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var jsonString: String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            jsonString= it.getString(JSON_OBJECT)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            SingleScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(JSON_OBJECT, param1)

                }
            }
    }
}