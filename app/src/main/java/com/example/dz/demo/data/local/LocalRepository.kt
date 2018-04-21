package com.example.dz.demo.data.local

import com.example.dz.demo.data.model.ItemResponse
import com.example.dz.demo.util.AppExecutors
import com.example.dz.demo.util.FileUtils
import com.google.gson.Gson
import io.reactivex.Single

class LocalRepository {
    private var fileUtils = FileUtils()
    private var appExecutors = AppExecutors()
    fun getItems(callBack: CallBack) {
        appExecutors.diskIO.execute {
            var gson = Gson()
            val itemResponse = gson.fromJson(fileUtils.getFileString("all.json"), ItemResponse::class.java)
            appExecutors.mainThread.execute {
                callBack.callBack(Single.just(itemResponse))
            }
        }
    }

    interface CallBack {
        fun callBack(single: Single<ItemResponse>)
    }
}