package com.hasan.adapterdelegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hasan.adapterdelegates.model.PostModel

class PostPremiumAdapterDelegate(val viewType: Int, val onPremiumPostClick: (String) -> Unit) {

    fun isTargetViewType(items:List<PostModel>, position: Int): Boolean{
        return (items[position].type == viewType)
    }

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_premium, parent, false)
        return PremiumPostViewHolder(view)
    }

    fun onBindViewHolder(items: List<PostModel>, position: Int, holder: RecyclerView.ViewHolder){
        (holder as PremiumPostViewHolder).onBind(items[position], onPremiumPostClick)
    }

}

class PremiumPostViewHolder(premiumPostView: View): RecyclerView.ViewHolder(premiumPostView){
    private val textView: TextView = premiumPostView.findViewById(R.id.post_text)
    private val imageView: ShapeableImageView = premiumPostView.findViewById(R.id.post_image)

    fun onBind(post: PostModel, onPremiumPostClick: (String) -> Unit){
        textView.text = post.text
        imageView.setImageResource(post.image)

        itemView.setOnClickListener {
            onPremiumPostClick("premium click")
        }
    }
}