package com.example.dz.demo.feature.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz.demo.R
import com.example.dz.demo.data.model.Item
import com.example.dz.demo.databinding.ViewListItemBinding


class ItemAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var list = emptyList<Item>()
    fun setItems(list: List<Item>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var itemViewBinding: ViewDataBinding? = null
        itemViewBinding = DataBindingUtil.inflate<ViewListItemBinding>(LayoutInflater.from(parent.context), R.layout.view_list_item, parent, false)
        val mainViewHolder = MainViewHolder(itemViewBinding)
        if (viewType == SOULD) {
            mainViewHolder.iv.visibility = View.VISIBLE
        } else {
            mainViewHolder.iv.visibility = View.GONE
        }
        return mainViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    private var STATUS: String? = "sold_out"
    private var NORMAL = 0
    private var SOULD = 1
    override fun getItemViewType(position: Int): Int {
        if (list.get(position).status.equals(STATUS)) {
            return SOULD
        } else {
            return NORMAL
        }
    }
}