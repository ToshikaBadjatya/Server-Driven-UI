package com.example.xml.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xml.container.FieldContainer
import com.example.xml.databinding.FragmentSingleScreenBinding


private const val JSON_OBJECT = "json_object"


class SingleScreenFragment : BaseFragment() {
    lateinit var binding: FragmentSingleScreenBinding
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
        binding= FragmentSingleScreenBinding.inflate(requireActivity().layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       renderUi(requireContext(),jsonString, binding.container)


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