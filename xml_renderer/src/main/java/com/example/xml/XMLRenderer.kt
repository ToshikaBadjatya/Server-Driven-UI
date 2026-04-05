package com.example.xml

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class XMLRenderer(multiPage: Boolean, jsonString: String?) {
    init {

    }
     fun renderPrimitive(context: Context,item: Any) {

    }
    fun renderUi(context: Context,jsonString: String){
        try {
           val jsonObject= JSONObject(jsonString)
           renderObject(context,jsonObject)
        }catch (e: Exception){
            val jsonArray= JSONArray(jsonString)
            renderArray(context,jsonArray)
        }
        catch (e: Exception){
            throw Exception("Invalid input json")
        }
    }

     fun renderObject(context: Context,json: JSONObject) {

    }
    fun renderArray(context: Context,json: JSONArray) {
       for(i in 0 until json.length()){
           val ele=json.get(i)
           when(ele){
               is JSONObject->{
                   renderObject(context,ele)
               }
               else->{
                   renderPrimitive(context,ele)
               }
           }
       }
    }
    class Builder() {
        private var multiPage: Boolean = false
        private var jsonString: String? = null
        fun setMultiPage(multiPage: Boolean): XMLRenderer.Builder {
            this.multiPage = multiPage
            return this@Builder
        }

        fun setJsonString(jsonString: String): XMLRenderer.Builder {
            this.jsonString = jsonString
            return this
        }

        fun build(): XMLRenderer {
            return XMLRenderer(multiPage,jsonString)
        }
    }
}