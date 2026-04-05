package com.example.xml.uifields.base

import android.content.Context
import android.widget.RelativeLayout
import org.json.JSONObject
enum class PossibleAlignments(apiValue: String){
    Row("row"),
    Column("column"),
    Box("box")

}

abstract class BaseUiView<T>(private val context: Context): RelativeLayout(context){

    abstract fun getFieldData():T?
    abstract fun render(jsonObject: JSONObject)
    abstract fun getType(): String

}