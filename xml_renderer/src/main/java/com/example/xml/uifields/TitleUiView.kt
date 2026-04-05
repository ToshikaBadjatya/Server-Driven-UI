package com.example.xml.uifields

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class TitleUiView(context: Context): BaseUiView<String>(context,) {
    var title: String?=null
    val textView = TextView(context).apply {
        textSize = 20f
        setTypeface(typeface, Typeface.BOLD)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
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