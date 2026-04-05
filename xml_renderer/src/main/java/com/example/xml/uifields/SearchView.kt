package com.example.xml.uifields

import android.content.Context
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class SearchView(context: Context) : BaseUiView<Any>(context) {
    override fun getFieldData(): Any {
        TODO("Not yet implemented")
    }

    override fun render(jsonObject: JSONObject) {
        TODO("Not yet implemented")
    }

    override fun getType(): String {
        return "search"
    }
}