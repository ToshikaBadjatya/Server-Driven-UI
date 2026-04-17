package com.example.xml.uifields

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.RelativeLayout.LayoutParams
import android.widget.TextView
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class DescriptionUiView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseUiView<String>(context) {
    var margin=12


    var title: String?=null


    override fun getFieldData(): String? {
        return title
    }

    override fun render(jsonObject: JSONObject) {
        title = jsonObject.optString("value")
        textView.text = title

        addView(textView)
    }

    override fun getType(): String {
        return "description"
    }

    val textView = TextView(context).apply {
        textSize = 14f
        setTypeface(typeface, Typeface.NORMAL)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
            setMargins(margin, margin, margin, margin)
        }
    }


}