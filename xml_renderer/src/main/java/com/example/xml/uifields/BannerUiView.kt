package com.example.xml.uifields

import android.content.Context
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class BannerUiView(context: Context): BaseUiView<String>(context,)  {
    override fun getFieldData(): String? {
        return null
    }

    override fun render(jsonObject: JSONObject) {
    }

    override fun getType(): String {
        return "banner"
    }
}