package com.hasan.adapterdelegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hasan.adapterdelegates.model.PostModel
import com.hasan.adapterdelegates.model.PostType

//open class PostAdapter(
//    private val dataSet: Array<PostModel>,
//    private val itemClick: (String) -> Unit,
//    private val premiumItemClick: (String) -> Unit
//) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    private val VIEW_TYPE_POST = 0
//    private val VIEW_TYPE_POST_PREMIUM = 1
//
//    override fun getItemViewType(position: Int): Int {
//        val post = dataSet[position]
//        return if (post.type.name == PostType.PREMIUM_POST.name) VIEW_TYPE_POST_PREMIUM else VIEW_TYPE_POST
//    }
//
//    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textView: TextView = itemView.findViewById(R.id.post_text)
//        private val image: ShapeableImageView = itemView.findViewById(R.id.post_image)
//
//        fun onBind(post: PostModel, onPostClick: (String) -> Unit) {
//            textView.text = post.text
//            image.setImageResource(post.image)
//
//            itemView.setOnClickListener {
//                onPostClick("non-premium")
//            }
//        }
//    }
//
//    inner class PremiumPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textView: TextView = itemView.findViewById(R.id.post_text)
//        private val image: ShapeableImageView = itemView.findViewById(R.id.post_image)
//
//        fun onBind(post: PostModel, onPremiumPostClick: (String) -> Unit) {
//            textView.text = post.text
//            image.setImageResource(post.image)
//
//            itemView.setOnClickListener {
//                onPremiumPostClick("premium")
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if(VIEW_TYPE_POST_PREMIUM == viewType){
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_premium, parent, false)
//            PremiumPostViewHolder(view)
//        }else{
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
//            PostViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when(holder.itemViewType){
//            VIEW_TYPE_POST -> {
//                (holder as PostViewHolder).onBind(
//                    post = dataSet[position],
//                    onPostClick = itemClick
//                )
//            }
//            VIEW_TYPE_POST_PREMIUM -> {
//                (holder as PremiumPostViewHolder).onBind(
//                    post = dataSet[position],
//                    onPremiumPostClick = premiumItemClick
//                )
//            }
//        }
//    }
//
//    override fun getItemCount(): Int = dataSet.size
//
////    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
////        holder.onBind(dataSet[position], itemClick)
////    }
//
//}