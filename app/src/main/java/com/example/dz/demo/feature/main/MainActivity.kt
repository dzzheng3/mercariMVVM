package com.example.dz.demo.feature.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.dz.demo.R
import com.example.dz.demo.databinding.ActivityProductListBinding
import kotlinx.android.synthetic.main.activity_product_list.*


class MainActivity : AppCompatActivity() {

    private var itemAdapter: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productListBinding = DataBindingUtil.setContentView<ActivityProductListBinding>(this, R.layout.activity_product_list)
        val pool = home_item_recycler_view.getRecycledViewPool()
        pool.setMaxRecycledViews(0, 10)
        home_item_recycler_view.recycledViewPool = pool
        home_item_recycler_view.layoutManager = GridLayoutManager(this, 3)
        itemAdapter = ItemAdapter()
        home_item_recycler_view.setHasFixedSize(true)
        home_item_recycler_view.adapter = itemAdapter
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.getList().observe(this, Observer {
            if (it != null) {
                itemAdapter?.setItems(it)
                itemAdapter?.notifyDataSetChanged()
            }
        })

        productListBinding.setLifecycleOwner(this)

    }
}
