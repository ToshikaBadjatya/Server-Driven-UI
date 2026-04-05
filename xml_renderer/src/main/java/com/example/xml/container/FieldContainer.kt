package com.example.xml.container

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import org.json.JSONObject

class FieldContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    fun renderUi(jsonObject: JSONObject) {
        // your rendering logic
    }
}