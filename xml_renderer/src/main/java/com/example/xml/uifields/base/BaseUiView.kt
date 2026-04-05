package com.example.xml.uifields.base

import android.content.Context
import android.widget.RelativeLayout
import org.json.JSONObject

abstract class BaseUiView<T>(private val context: Context): RelativeLayout(context){

    abstract fun getFieldData():T?
    abstract fun render(jsonObject: JSONObject)

}