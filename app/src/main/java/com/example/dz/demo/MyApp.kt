package com.example.dz.demo

import android.annotation.SuppressLint
import android.app.Application
import com.example.dz.demo.di.component.AppComponent
import com.example.dz.demo.di.component.DaggerAppComponent
import com.example.dz.demo.di.module.AppModule
import com.example.dz.demo.di.module.NetworkModule

class MyApp:Application(){
    internal var mAppComponent: AppComponent? = null
    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
        }
    }
}