package com.example.xml.uifields

import android.content.Context
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class BannerUiView(context: Context): BaseUiView<String>(context,)  {
    override fun getFieldData(): String? {
        TODO("Not yet implemented")
    }

    override fun render(jsonObject: JSONObject) {
        TODO("Not yet implemented")
    }

    override fun getType(): String {
        return "banner"
    }
}