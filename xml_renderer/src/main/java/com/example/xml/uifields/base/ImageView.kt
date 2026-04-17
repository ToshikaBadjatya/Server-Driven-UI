package com.example.xml.uifields.base

import android.content.Context
import android.util.Log
import android.widget.ImageView as AndroidImageView
import com.bumptech.glide.Glide
import com.example.xml.R
import org.json.JSONObject

class ImageView(context: Context) : BaseUiView<String>(context) {

    var url: String? = null

    private val imageView = AndroidImageView(context).apply {
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        scaleType = AndroidImageView.ScaleType.CENTER_CROP
        adjustViewBounds = true
    }

    init {
        addView(imageView)
    }

    override fun getFieldData(): String? = url

    override fun render(jsonObject: JSONObject) {
        url = jsonObject.optString("value").takeIf { it.isNotEmpty() }
        Log.e("url","got $url")

        Glide.with(context)
            .load(url)
            .into(imageView)

    }

    override fun getType(): String = "image"
}
