package com.example.xml.container

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import org.json.JSONObject

sealed class FieldContainer {
    data object Row : FieldContainer()
    data object Column : FieldContainer()
    data object Box : FieldContainer()
}
fun FieldContainer.toViewGroup(context: Context): ViewGroup {
    return when (this) {
        FieldContainer.Row -> LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
        }

        FieldContainer.Column -> LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }

        FieldContainer.Box -> FrameLayout(context)
    }
}