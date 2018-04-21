package com.example.dz.demo.feature.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.dz.demo.data.DataManager
import com.example.dz.demo.data.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private var liveData: MutableLiveData<List<Item>>
    private var dataManager: DataManager = DataManager()

    init {
        liveData = MutableLiveData<List<Item>>()
    }

    fun getList(): MutableLiveData<List<Item>> {
        dataManager.getList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                items, t2 -> liveData.postValue(items) }
        return liveData
    }
}