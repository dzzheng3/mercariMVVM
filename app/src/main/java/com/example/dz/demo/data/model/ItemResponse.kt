package com.example.dz.demo.data.model

import com.google.gson.annotations.SerializedName

data class ItemResponse(@SerializedName("result")
                        val result: String = "",
                        @SerializedName("data")
                        val data: List<Item>?)