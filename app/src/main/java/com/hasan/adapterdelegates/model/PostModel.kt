package com.hasan.adapterdelegates.model

data class PostModel(
    val type: Int,
    val image: Int,
    val text: String
)

enum class PostType{

    POST,
    PREMIUM_POST,
    AD

}