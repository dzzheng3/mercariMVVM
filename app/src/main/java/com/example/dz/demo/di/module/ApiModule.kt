package com.example.dz.demo.di.module

import com.example.dz.demo.data.remote.ItemApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun provideItemApi(retrofit: Retrofit): ItemApi =
            retrofit.create(ItemApi::class.java)
}