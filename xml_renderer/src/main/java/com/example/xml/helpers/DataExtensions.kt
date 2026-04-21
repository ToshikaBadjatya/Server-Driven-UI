package com.example.xml.helpers

import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.util.Date

inline fun <reified T> JSONArray.toList(): List<T> {
    val list = mutableListOf<T>()
    val gson = Gson()

    for (i in 0 until length()) {
        val item = get(i)
        val json = item.toString()
        list.add(gson.fromJson(json, T::class.java))
    }
    return list
}


inline fun <reified T> JSONObject.toObject(): T?{
    val gson = Gson()
    return gson.fromJson(this.toString(), T::class.java)

}
fun String.toDate(): Date?{
    return null
}