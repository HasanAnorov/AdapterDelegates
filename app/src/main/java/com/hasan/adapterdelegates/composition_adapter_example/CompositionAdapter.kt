package com.hasan.adapterdelegates.composition_adapter_example

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.adapterdelegates.model.PostModel


class CompositionAdapter(
    private val items: List<PostModel>,
    private val newsAdapterDelegate: NewsAdapterDelegate,
    private val postAdapterDelegate: PostAdapterDelegate,
    private val premiumPostAdapterDelegate: PostPremiumAdapterDelegate
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_POST = 0
    private val VIEW_TYPE_POST_PREMIUM = 1
    private val VIEW_TYPE_NEWS_TEASER = 2

    override fun getItemViewType(position: Int): Int {
        if(newsAdapterDelegate.isTargetViewType(items, position)){
            return newsAdapterDelegate.viewType
        }else if(postAdapterDelegate.isTargetViewType(items, position)){
            return postAdapterDelegate.viewType
        }else if (premiumPostAdapterDelegate.isTargetViewType(items, position)){
            return premiumPostAdapterDelegate.viewType
        }
        throw IllegalArgumentException("No delegate found")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(postAdapterDelegate.viewType == viewType){
             return postAdapterDelegate.onCreateViewHolder(parent)
        }else if(newsAdapterDelegate.viewType == viewType){
             return newsAdapterDelegate.onCreateViewHolder(parent)
        }else if(premiumPostAdapterDelegate.viewType == viewType){
            return premiumPostAdapterDelegate.onCreateViewHolder(parent)
        }
        throw IllegalArgumentException("No delegate found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            VIEW_TYPE_POST -> {
                postAdapterDelegate.onBindViewHolder(items, position, holder)
            }
            VIEW_TYPE_POST_PREMIUM -> {
                premiumPostAdapterDelegate.onBindViewHolder(items, position, holder)
            }
            VIEW_TYPE_NEWS_TEASER -> {
                newsAdapterDelegate.onBindViewHolder(items, position, holder)
            }
        }
    }
}