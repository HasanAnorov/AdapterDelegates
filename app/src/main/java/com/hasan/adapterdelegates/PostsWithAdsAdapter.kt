package com.hasan.adapterdelegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.adapterdelegates.model.PostModel
import com.hasan.adapterdelegates.model.PostType

const val TAG = "ahi3646"

//class PostsWithAdsAdapter(
//    private val dataSet: Array<PostModel>,
//    private val onAdClicked: (String) -> Unit,
//    onItemClick: (String) -> Unit,
//    onPremiumItemClick: (String) -> Unit
//) : PostAdapter(dataSet, onItemClick, onPremiumItemClick) {
//
//    private val VIEW_TYPE_NEWS_TEASER = 2
//
//    override fun getItemViewType(position: Int): Int {
//        return if (dataSet[position].type == 2) {
//            VIEW_TYPE_NEWS_TEASER
//        } else super.getItemViewType(position)
//    }
//
//    inner class AdViewHolder(adView: View) : RecyclerView.ViewHolder(adView) {
//        private val adText = adView.findViewById<TextView>(R.id.ad_text)
//        fun onBind(post: PostModel, onAdClicked: (String) -> Unit) {
//            adText.text = "Add text - ${post.text}"
//
//            itemView.setOnClickListener {
//                onAdClicked("ad click")
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (VIEW_TYPE_NEWS_TEASER == viewType) {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
//            AdViewHolder(view)
//        } else {
//            super.onCreateViewHolder(parent, viewType)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder.itemViewType) {
//            VIEW_TYPE_NEWS_TEASER -> {
//                (holder as AdViewHolder).onBind(dataSet[position], onAdClicked)
//            }
//
//            else -> {
//                super.onBindViewHolder(holder, position)
//            }
//        }
//    }
//
//}