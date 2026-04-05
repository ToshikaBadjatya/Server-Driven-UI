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

    var title: String?=null


    override fun getFieldData(): String? {
        return title
    }

    override fun render(jsonObject: JSONObject) {
        title=jsonObject.optString("description")
        addView(textView)
    }

    val textView = TextView(context).apply {
        textSize = 14f
        setTypeface(typeface, Typeface.NORMAL)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }


}