package com.example.xml.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xml.databinding.ListItemBinding
import com.example.xml.databinding.ListItemHorizontalBinding

class ItemListItem(
    val title: String,
    val description: String? = null,
    val img: String? = null
)

class ItemListAdapter(val layout: Int) : RecyclerView.Adapter<ItemListAdapter.UiViewHolder>() {

    companion object {
        const val LAYOUT_VERTICAL = 0
        const val LAYOUT_HORIZONTAL = 1
    }

    private var list = mutableListOf<ItemListItem>()

    sealed class UiViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        abstract fun render(item: ItemListItem)

        class VerticalViewHolder(private val binding: ListItemBinding) :
            UiViewHolder(binding.root) {
            override fun render(item: ItemListItem) {
                binding.itemTitle.text = item.title
                if (item.description != null) {
                    binding.itemDescription.visibility = View.VISIBLE
                    binding.itemDescription.text = item.description
                } else {
                    binding.itemDescription.visibility = View.GONE
                }
                if (item.img != null) {
                    binding.itemImage.visibility = View.VISIBLE
                    Glide.with(binding.itemImage.context)
                        .load(item.img)
                        .into(binding.itemImage)
                } else {
                    binding.itemImage.visibility = View.GONE
                }
            }
        }

        class HorizontalViewHolder(private val binding: ListItemHorizontalBinding) :
            UiViewHolder(binding.root) {
            override fun render(item: ItemListItem) {
                binding.itemTitle.text = item.title
                if (item.description != null) {
                    binding.itemDescription.visibility = View.VISIBLE
                    binding.itemDescription.text = item.description
                } else {
                    binding.itemDescription.visibility = View.GONE
                }
                if (item.img != null) {
                    binding.itemImage.visibility = View.VISIBLE
                    Glide.with(binding.itemImage.context)
                        .load(item.img)
                        .into(binding.itemImage)
                } else {
                    binding.itemImage.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == LAYOUT_HORIZONTAL) {
            UiViewHolder.HorizontalViewHolder(
                ListItemHorizontalBinding.inflate(inflater, parent, false)
            )
        } else {
            UiViewHolder.VerticalViewHolder(
                ListItemBinding.inflate(inflater, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: UiViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun submitList(items: List<ItemListItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
}
