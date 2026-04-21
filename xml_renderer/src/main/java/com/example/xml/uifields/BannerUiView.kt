package com.example.xml.uifields

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.xml.R
import com.example.xml.helpers.toDate
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject
import java.util.Date

class BannerUiView(context: Context) : BaseUiView<String>(context) {

    var title: String? = null
    var description: String? = null
    var icon: String? = null
    var color: String? = null
    var startTime: Date? = null
    var endTime: Date? = null

    private val view = LayoutInflater.from(context).inflate(R.layout.banner_view, this, false)

    override fun getFieldData(): String? = null

    override fun render(jsonObject: JSONObject) {
        title       = jsonObject.optString("title").takeIf { it.isNotEmpty() }
        description = jsonObject.optString("description").takeIf { it.isNotEmpty() }
        icon        = jsonObject.optString("icon").takeIf { it.isNotEmpty() }
        color       = jsonObject.optString("color").takeIf { it.isNotEmpty() }
        startTime   = jsonObject.optString("start_time").takeIf { it.isNotEmpty() }
                          ?.toDate()
        endTime     = jsonObject.optString("end_time").takeIf { it.isNotEmpty() }
                          ?.toDate()

        val bannerCard        = view.findViewById<CardView>(R.id.bannerCard)
        val bannerTitle       = view.findViewById<TextView>(R.id.bannerTitle)
        val bannerDescription = view.findViewById<TextView>(R.id.bannerDescription)
        val bannerIcon        = view.findViewById<ImageView>(R.id.bannerIcon)

        bannerTitle.text = title ?: ""

        if (description != null) {
            bannerDescription.visibility = View.VISIBLE
            bannerDescription.text = description
        } else {
            bannerDescription.visibility = View.GONE
        }

        if (icon != null) {
            bannerIcon.visibility = View.VISIBLE
            Glide.with(context)
                .load(icon)
                .into(bannerIcon)
        } else {
            bannerIcon.visibility = View.GONE
        }

        color?.let {
            bannerCard.setCardBackgroundColor(Color.parseColor(it))
        }

        addView(view)
    }

    override fun getType(): String = "banner"
}
