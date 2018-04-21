package com.example.dz.demo.data

import com.example.dz.demo.data.local.LocalRepository
import com.example.dz.demo.data.model.Item
import com.example.dz.demo.data.model.ItemResponse
import com.example.dz.demo.data.remote.RemoteRepository
import io.reactivex.Single

class DataManager : LocalRepository.CallBack {
    private var remoteRepository = RemoteRepository()
    private var localRepository = LocalRepository()

    fun getList(): Single<List<Item>> {
        return remoteRepository.provideItemApi().getItems().toObservable()
            .flatMapIterable { t: ItemResponse -> t.data }
            .toList()
    }
    private var items: Single<ItemResponse>? = null
    fun getListLocal(): Single<MutableList<Item>>? {
        return items?.toObservable()
            ?.flatMapIterable { t: ItemResponse -> t.data }
            ?.toList()
    }

    override fun callBack(single: Single<ItemResponse>) {
        items = single
    }
}