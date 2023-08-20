package com.hasan.adapterdelegates.composition_adapter_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hasan.adapterdelegates.R
import com.hasan.adapterdelegates.model.PostModel


class PostAdapterDelegate(
    val viewType: Int,
    private val onPostItemClick: (String) -> Unit
) {

    fun isTargetViewType(items: List<PostModel>, position: Int): Boolean{
        return (items[position].type == viewType)
    }

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    fun onBindViewHolder(items: List<PostModel>, position: Int, holder: RecyclerView.ViewHolder){
        (holder as PostViewHolder).onBind(items[position], onPostItemClick)
    }

}

class PostViewHolder(postView: View): RecyclerView.ViewHolder(postView){
    private val postText: TextView = postView.findViewById(R.id.premium_text)
    private val postImage: ShapeableImageView = postView.findViewById(R.id.premium_image)

    fun onBind(post: PostModel, onPostItemClick: (String) -> Unit){
        postText.text = post.text
        postImage.setImageResource(post.image)

        itemView.setOnClickListener {
            onPostItemClick("post click")
        }
    }
}