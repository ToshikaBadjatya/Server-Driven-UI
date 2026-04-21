package com.example.xml.uifields

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import com.example.xml.uifields.base.BaseUiView
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject

open class InputUiView(context: Context): BaseUiView<String>(context) {
    var value: String?=null
    var preText: String?=null
    var margin=12

    val inputView = TextInputEditText(context).apply {
        textSize = 20f
        setTypeface(typeface, Typeface.BOLD)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
            setMargins(margin, margin, margin, margin)
        }
    }
    override fun getFieldData(): String? {
      return value
    }

    override fun render(jsonObject: JSONObject) {
        preText = jsonObject.optString("title")
        preText?.let {
            inputView.hint=it
        }
        addView(inputView)
    }

    override fun getType(): String {
        return "input"
    }
}