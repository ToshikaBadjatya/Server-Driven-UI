package com.example.xml

import androidx.fragment.app.FragmentManager
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.xml.screens.MultiScreenFragment
import com.example.xml.screens.SingleScreenFragment
import org.json.JSONArray
import org.json.JSONObject

class XMLRenderer(
    private val fragmentManager: FragmentManager,
    private val containerId: Int,
    multiPage: Boolean,
    jsonString: String?
) {
    init {

        val fragment = if (multiPage) {
            MultiScreenFragment.newInstance(jsonString ?: "")
        } else {
            SingleScreenFragment.newInstance(jsonString ?: "")
        }

        fragmentManager.beginTransaction()
            .add(containerId, fragment as Fragment)
            .commit()
    }
    class Builder(val fragmentManager: FragmentManager, val containerId: Int) {
        private var multiPage: Boolean = false
        private var jsonString: String? = null

        fun setMultiPage(multiPage: Boolean): Builder {
            this.multiPage = multiPage
            return this
        }

        fun setJsonString(jsonString: String): Builder {
            this.jsonString = jsonString
            return this
        }

        fun build(): XMLRenderer {
            return XMLRenderer(fragmentManager, containerId, multiPage, jsonString)
        }
    }
}