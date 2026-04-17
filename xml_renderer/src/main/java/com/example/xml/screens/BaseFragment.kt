package com.example.xml.screens


import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.xml.errors.CustomErrors
import com.example.xml.uifields.BannerUiView
import com.example.xml.uifields.DescriptionUiView
import com.example.xml.uifields.HorizontalListView
import com.example.xml.uifields.InputUiView
import com.example.xml.uifields.SearchView
import com.example.xml.uifields.TitleUiView
import com.example.xml.uifields.VerticalListView
import com.example.xml.uifields.WebUiView
import com.example.xml.uifields.base.BaseUiView
import com.example.xml.uifields.base.ImageView
import com.example.xml.uifields.base.PossibleAlignments
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

open class BaseFragment: Fragment() {
    fun renderPrimitive(context: Context, item: JSONObject, container: ViewGroup) {
        val type = item.getString("type") ?: throw CustomErrors.InvalidConstraints
        val view = getViewFromType(context, type) ?: return
        view.render(item)
        container.addView(view)
    }
    fun renderUi(context: Context, jsonString: String?, container: ViewGroup){
        if(jsonString==null){
            return
        }
        try {
            val jsonObject= JSONObject(jsonString)
            renderObject(context,jsonObject,container)
        }catch (e: Exception){
            val jsonArray= JSONArray(jsonString)
            renderArray(context,jsonArray,container)
        }
        catch (e: Exception){
            throw Exception("Invalid input json")
        }
    }

    fun renderObject(context: Context,json: JSONObject,fieldContainer: ViewGroup) {
       try {
           val alignment=json.getString("alignment")?:throw CustomErrors.InvalidConstraints
           val children=json.getJSONArray("content")?:throw CustomErrors.InvalidConstraints
           val possibleAlignments= PossibleAlignments.getAlignment(alignment)
           possibleAlignments?.let {
               val viewGroup=it.getViewGroup(context)
               renderArray(context,children,viewGroup)
               fieldContainer.addView(viewGroup)

           }


       }catch (e: JSONException){

       }
       catch (e: CustomErrors){

       }
        catch (e: Exception){

        }
    }
    fun renderArray(context: Context, json: JSONArray, container: ViewGroup) {
        for(i in 0 until json.length()){
            val ele=json.get(i)
            when(ele){
                is JSONObject->{
                    if(ele.has("content")){
                        renderObject(context,ele, container)
                    }
                    else{
                        renderPrimitive(context,ele,container)
                    }
                }
                else->{
                }
            }
        }
    }
    private fun buildRegistry(context: Context): Map<String, BaseUiView<*>> = listOf(
        TitleUiView(context),
        DescriptionUiView(context),
        WebUiView(context),
        BannerUiView(context),
        InputUiView(context),
        HorizontalListView(context),
        VerticalListView(context),
        SearchView(context),
        ImageView(context)
    ).associateBy { it.getType() }

    fun getViewFromType(context: Context, type: String): BaseUiView<*>? {
        return buildRegistry(context)[type]
    }
}