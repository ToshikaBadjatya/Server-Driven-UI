package com.example.xml.screens


import android.content.Context
import androidx.fragment.app.Fragment
import org.json.JSONArray
import org.json.JSONObject

open class BaseFragment: Fragment() {
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
}