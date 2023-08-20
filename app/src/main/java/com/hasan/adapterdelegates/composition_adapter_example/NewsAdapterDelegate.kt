package com.hasan.adapterdelegates.composition_adapter_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.adapterdelegates.R
import com.hasan.adapterdelegates.model.PostModel

class NewsAdapterDelegate(val viewType: Int, private val onNewsClicked: (String) -> Unit) {

    fun isTargetViewType(items: List<PostModel>, position: Int): Boolean =
        items[position].type == viewType

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        return AdViewHolder(view)
    }

    fun onBindViewHolder(items: List<PostModel>, position: Int, holder: RecyclerView.ViewHolder){
        (holder as AdViewHolder).onBind(items[position], onNewsClicked)
    }

}

private class AdViewHolder(adView: View) : RecyclerView.ViewHolder(adView) {
    private val adText = adView.findViewById<TextView>(R.id.ad_text)
    fun onBind(post: PostModel, onAdClicked: (String) -> Unit) {
        adText.text = "Add text - ${post.text}"

        itemView.setOnClickListener {
            onAdClicked("ad click")
        }
    }
}
