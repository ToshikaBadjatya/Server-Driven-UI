package com.example.xml.uifields

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONObject
class HorizontalListView(context: Context): ItemListView(context){
    override fun getOrientation(): Int {
       return RecyclerView.HORIZONTAL
    }

    override fun getType(): String {
        return "horizontal_list"
    }

}
class VerticalListView(context: Context): ItemListView(context){
    override fun getOrientation(): Int {
        return RecyclerView.VERTICAL
    }

    override fun getType(): String {
        return "vertical_list"
    }

}
abstract class ItemListView(context: Context): BaseUiView<List<Any>>(context) {
    override fun getFieldData(): List<Any>? {
        return emptyList()
    }

    override fun render(jsonObject: JSONObject) {
    }
    abstract fun getOrientation(): Int
}