package com.example.koqli.ui.screen.Items

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.koqli.R
import com.example.koqli.databinding.FragmentItemListItemBinding
import com.example.koqli.databinding.FragmentItemListItemLoadingBinding
import com.example.koqli.databinding.ItemTagBinding
import com.example.koqli.domain.item.Item
import com.example.koqli.domain.tagging.Tagging
import com.example.koqli.domain.user.User
import java.util.logging.Logger

/**
 * Created by biwaishi on 2017/12/28.
 */

class ItemListRecyclerViewAdapter(private val onTappedItem: ((Item) -> Unit)?,
                                  private val onTappedUser: ((User) -> Unit)?,
                                  private val onTappedTag: ((Tagging) -> Unit)?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val itemList: MutableList<Item> = mutableListOf()
    var isLoading = false
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ItemListRecyclerViewItemViewHolder) {
            val item = itemList.get(position)
            holder.binding.setVariable(BR.item, item)

            val requestOptions = RequestOptions()
            requestOptions.centerCrop()

            item.user?.let { user ->
                Glide
                        .with(holder.binding.root.context)
                        .load(user.profileImageUrl)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(holder.binding.fragmentItemListItemIcon)

                holder.binding.fragmentItemListItemIcon.setOnClickListener {
                    onTappedUser?.invoke(user)
                }

                holder.binding.fragmentItemListItemContributor.setOnClickListener {
                    onTappedUser?.invoke(user)
                }
            }

            holder.binding.root.setOnClickListener {
                onTappedItem?.invoke(item)
            }

            holder.binding.fragmentItemListItemTagsLayout.removeAllViews()
            item.tags?.forEach { tagging ->
                val layoutInflater = LayoutInflater.from(holder.binding.root.context)
                val tagLayout = DataBindingUtil.inflate<ItemTagBinding>(layoutInflater, R.layout.item_tag, null, false)
                val marginLayoutParams = ViewGroup.MarginLayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                marginLayoutParams.rightMargin = 20
                tagLayout.root.layoutParams = marginLayoutParams
                tagLayout.itemTagName.text = tagging!!.name

                tagLayout.itemTag.setOnClickListener {
                    onTappedTag?.invoke(tagging)
                }

                holder.binding.fragmentItemListItemTagsLayout.addView(tagLayout.itemTag)
            }
            holder.binding.executePendingBindings()
        } else if (holder is ItemListRecyclerViewLoadingItemViewHolder) {
            holder.binding.executePendingBindings()
        }

    }

    fun addItems(dataList: Collection<Item>) {
        itemList.addAll(dataList)
        notifyDataSetChanged()
    }

    enum class ItemType(val value: Int) {
        ITEM(0), LOADING(1)
    }

    override fun getItemViewType(position: Int): Int {
        if (position < itemList.count()) {
            return ItemType.ITEM.value
        } else {
            return ItemType.LOADING.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            ItemType.ITEM.value -> {
                val binding = DataBindingUtil.inflate<FragmentItemListItemBinding>(LayoutInflater.from(parent.context), R.layout.fragment_item_list_item, parent, false)
                ItemListRecyclerViewItemViewHolder(binding)
            }
            ItemType.LOADING.value -> {
                val binding = DataBindingUtil.inflate<FragmentItemListItemLoadingBinding>(LayoutInflater.from(parent.context), R.layout.fragment_item_list_item_loading, parent, false)
                ItemListRecyclerViewLoadingItemViewHolder(binding)
            }
            else -> {
                throw IllegalStateException()
            }
        }

    override fun getItemCount(): Int {
        return itemList.count() + (if(isLoading) 1 else 0)
    }

    class ItemListRecyclerViewItemViewHolder(val binding: FragmentItemListItemBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemListRecyclerViewLoadingItemViewHolder(val binding: FragmentItemListItemLoadingBinding) : RecyclerView.ViewHolder(binding.root)
}