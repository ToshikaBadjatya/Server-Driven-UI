package com.example.compose

import org.json.JSONObject

 class ComposeRenderer private constructor(multiPage: Boolean, jsonString1: String?) {
    fun handlePrimitive(item: Any) {

    }

    fun renderObject(json: JSONObject) {

    }

    class Builder() {
        private var multiPage: Boolean = false
        private var jsonString: String? = null
        fun setMultiPage(multiPage: Boolean): ComposeRenderer.Builder {
            this.multiPage = multiPage
            return this@Builder
        }

        fun setJsonString(jsonString: String): ComposeRenderer.Builder {
            this.jsonString = jsonString
            return this
        }

        fun build(): ComposeRenderer {
            return ComposeRenderer(multiPage,jsonString)
        }
    }
}