package com.example.xml.uifields

import android.R.color
import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject

class ImageView(context: Context) : BaseUiView<String>(context) {

    var url: String? = null

    private val imageView = AppCompatImageView(context).apply {
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        scaleType= ImageView.ScaleType.CENTER_CROP
        setBackgroundColor(color.darker_gray)
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