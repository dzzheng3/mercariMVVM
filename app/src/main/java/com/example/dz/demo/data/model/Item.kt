package com.example.dz.demo.data.model

import com.google.gson.annotations.SerializedName

data class Item(@SerializedName("num_comments")
                    val numComments: Int = 0,
                @SerializedName("price")
                    val price: Int = 0,
                @SerializedName("name")
                    val name: String = "",
                @SerializedName("photo")
                    val photo: String = "",
                @SerializedName("id")
                    val id: String = "",
                @SerializedName("num_likes")
                    val numLikes: Int = 0,
                @SerializedName("status")
                    val status: String = "")