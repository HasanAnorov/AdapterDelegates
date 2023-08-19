package com.hasan.adapterdelegates.model

data class PostModel(
    val type: PostType,
    val image: Int,
    val text: String
)

enum class PostType{

    POST,
    PREMIUM_POST,
    AD

}