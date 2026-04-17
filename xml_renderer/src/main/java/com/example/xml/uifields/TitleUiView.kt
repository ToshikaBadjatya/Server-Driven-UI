package com.example.xml.uifields

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class TitleUiView(context: Context): BaseUiView<String>(context,) {
    var title: String?=null
    var margin=12
    val textView = TextView(context).apply {
        textSize = 20f
        setTypeface(typeface, Typeface.BOLD)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
            setMargins(margin, margin, margin, margin)
        }
    }


    override fun getFieldData(): String? {
      return title
    }

    override fun render(jsonObject: JSONObject) {
        title = jsonObject.optString("value")
        textView.text = title
        addView(textView)
    }

    override fun getType(): String {
        return "title"
    }
}