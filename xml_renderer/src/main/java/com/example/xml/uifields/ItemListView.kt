package com.example.xml.uifields

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xml.helpers.ItemListAdapter
import com.example.xml.helpers.ItemListItem
import com.example.xml.helpers.toList
import com.example.xml.uifields.base.BaseUiView
import org.json.JSONArray
import org.json.JSONObject

class HorizontalGridView(context: Context) : ItemListView(context) {
    override fun getOrientation() = RecyclerView.HORIZONTAL
    override fun getLayout() = ItemListAdapter.LAYOUT_HORIZONTAL
    override fun getType() = "horizontal_grid"
    override fun render(jsonObject: JSONObject) {
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = adapter

        val content = jsonObject.optJSONArray("items") ?: JSONArray()
        content.toList<ItemListItem>()?.let {
            adapter.submitList(it)
        }

    }

}
class HorizontalListView(context: Context) : ItemListView(context) {
    override fun getOrientation() = RecyclerView.HORIZONTAL
    override fun getLayout() = ItemListAdapter.LAYOUT_HORIZONTAL
    override fun getType() = "horizontal_list"

}

class VerticalListView(context: Context) : ItemListView(context) {
    override fun getOrientation() = RecyclerView.VERTICAL
    override fun getLayout() = ItemListAdapter.LAYOUT_VERTICAL
    override fun getType() = "vertical_list"
}

abstract class ItemListView(context: Context) : BaseUiView<List<Any>>(context) {

    protected val adapter by lazy { ItemListAdapter(getLayout()) }

    protected val recyclerView = RecyclerView(context).apply {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        addView(recyclerView)
    }

    override fun getFieldData(): List<Any>? = emptyList()

    override fun render(jsonObject: JSONObject) {

        recyclerView.layoutManager = LinearLayoutManager(context, getOrientation(), false)
        recyclerView.adapter = adapter

        val content = jsonObject.optJSONArray("items") ?: JSONArray()
         content.toList<ItemListItem>()?.let {
             adapter.submitList(it)
         }

    }

    abstract fun getOrientation(): Int
    abstract fun getLayout(): Int
}
