package com.example.dz.demo.feature.main

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.example.dz.demo.BR
import com.example.dz.demo.R
import com.example.dz.demo.data.model.Item


class MainViewHolder(var dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {
    var iv : ImageView =  dataBinding.root.findViewById(R.id.iv)
    fun bind(item: Item) {
        dataBinding.setVariable(BR.item, item)
        dataBinding.executePendingBindings()
    }

}