package com.example.xml.uifields

import android.content.Context
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class SearchView(context: Context) : InputUiView(context) {

    override fun getType(): String {
        return "search"
    }
}