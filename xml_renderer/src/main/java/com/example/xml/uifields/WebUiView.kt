package com.example.xml.uifields

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout.LayoutParams
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class WebUiView(context: Context): BaseUiView<String>(context) {
    var url: String?=null
    @SuppressLint("SetJavaScriptEnabled")
    val webView = WebView(context).apply {
        webViewClient = WebViewClient()
        settings.javaScriptEnabled = true
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
    override fun getFieldData(): String? {
        return url
    }

    override fun render(jsonObject: JSONObject) {
        url = jsonObject.optString("value")
        url?.let {
            webView.loadUrl(it)
            addView(webView)
        }
    }

    override fun getType(): String {
        return "webpage"
    }
}