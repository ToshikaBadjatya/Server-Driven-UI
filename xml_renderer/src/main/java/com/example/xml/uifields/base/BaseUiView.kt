package com.example.xml.uifields.base

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import org.json.JSONObject
enum class PossibleAlignments(val apiValue: String){
    Row("row"){
        override fun getViewGroup(context: Context): ViewGroup {
           return LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
            }
        }

    },
    Column("column") {
        override fun getViewGroup(context: Context): ViewGroup {
            return LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
            }
        }
    },
    Box("box") {
        override fun getViewGroup(context: Context): ViewGroup {
            return FrameLayout(context)
        }
    };
    companion object{
        fun getAlignment(apiValue: String): PossibleAlignments?{
            return PossibleAlignments.values().find { it.apiValue==apiValue }
        }

    }
    abstract fun getViewGroup(context: Context): ViewGroup

}

abstract class BaseUiView<T>(private val context: Context): RelativeLayout(context){

    abstract fun getFieldData():T?
    abstract fun render(jsonObject: JSONObject)
    abstract fun getType(): String

}