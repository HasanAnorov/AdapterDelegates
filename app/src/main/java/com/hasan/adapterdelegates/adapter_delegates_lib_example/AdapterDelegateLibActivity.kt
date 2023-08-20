package com.hasan.adapterdelegates.adapter_delegates_lib_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.hasan.adapterdelegates.R
import com.hasan.adapterdelegates.databinding.ActivityAdapterDelegateLibBinding
import com.hasan.adapterdelegates.model.PostModel

class AdapterDelegateLibActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdapterDelegateLibBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdapterDelegateLibBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fakeData = listOf(
            PostModel(2, R.drawable.ic_launcher_foreground, "Test text 1"),
            PostModel(2, R.drawable.ic_launcher_foreground, "Test text 2"),
            PostModel(2, R.drawable.ic_launcher_foreground, "Test text 3"),
            PostModel(2, R.drawable.ic_launcher_foreground, "Test text 4"),
            PostModel(0, R.drawable.ic_launcher_foreground, "Test text 5"),
            PostModel(0, R.drawable.ic_launcher_foreground, "Test text 6"),
            PostModel(3, R.drawable.ic_launcher_foreground, "Test text 7"),
            PostModel(3, R.drawable.ic_launcher_foreground, "Test text 8"),
            PostModel(3, R.drawable.ic_launcher_foreground, "Test text 9"),
            PostModel(0, R.drawable.ic_launcher_foreground, "Test text 10"),
            PostModel(0, R.drawable.ic_launcher_foreground, "Test text 11"),
            PostModel(1, R.drawable.ic_launcher_foreground, "Test text 12"),
            PostModel(1, R.drawable.ic_launcher_foreground, "Test text 13"),
            PostModel(1, R.drawable.ic_launcher_foreground, "Test text 14"),
            PostModel(0, R.drawable.ic_launcher_foreground, "Test text 15")
        )

        val bannersFakeData = listOf(
            PostModel(1, R.drawable.ic_launcher_background, "banner text"),
            PostModel(1, R.drawable.ic_launcher_background, "banner text"),
            PostModel(1, R.drawable.ic_launcher_background, "banner text"),
            PostModel(1, R.drawable.ic_launcher_background, "banner text"),
        )

        fun bannerAdapterDelegate(onBannerItemClicked: (String) -> Unit) =
            adapterDelegate<PostModel, PostModel>(
                layout = R.layout.item_banner
            ) {
                val bannerText = findViewById<TextView>(R.id.banner_text)
                val bannerImage = findViewById<ShapeableImageView>(R.id.banner_image)

                itemView.setOnClickListener {
                    onBannerItemClicked("banner")
                }

                bind {
                    bannerText.text = item.text
                    bannerImage.setImageResource(item.image)
                }
            }

        val bannersAdapter = ListDelegationAdapter(
            bannerAdapterDelegate{

            }
        )
        bannersAdapter.items = bannersFakeData

        fun bannersAdapterDelegate() = adapterDelegate(
            layout = R.layout.item_banners,
            on = { item: PostModel, items: List<PostModel>, position: Int ->
                item.type == 3
            }
        ) {
            val bannerTitle = findViewById<TextView>(R.id.banner_title)
            val bannerRecyclerView = findViewById<RecyclerView>(R.id.bannerRecyclerView)

            bind {
                bannerTitle.text = "Banner title - ${item.text}"
                bannerRecyclerView.layoutManager = LinearLayoutManager(
                    this@AdapterDelegateLibActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                bannerRecyclerView.adapter = bannersAdapter
            }
        }

        fun postAdapterDelegate(onPostItemClick: (String) -> Unit) =
            adapterDelegate<PostModel, PostModel>(
                layout = R.layout.item_post,
                on = { item: PostModel, items: List<PostModel>, position: Int ->
                    item.type == 0
                }
            ) {
                val postText = findViewById<TextView>(R.id.post_text)
                val postImage = findViewById<ShapeableImageView>(R.id.post_image)

                bind {
                    postText.text = item.text
                    postImage.setImageResource(item.image)

                    postImage.setOnClickListener {
                        onPostItemClick("post")
                    }
                }
            }

        fun premiumPostAdapterDelegate(onPremiumItemClick: (String) -> Unit) =
            adapterDelegate<PostModel, PostModel>(
                layout = R.layout.item_post_premium,
                on = { item: PostModel, items: List<PostModel>, position: Int ->
                    item.type == 1
                }
            ) {
                val premiumText = findViewById<TextView>(R.id.premium_text)
                val premiumImage = findViewById<ShapeableImageView>(R.id.premium_image)

                bind {
                    premiumText.text = item.text
                    premiumImage.setImageResource(item.image)

                    premiumImage.setOnClickListener {
                        onPremiumItemClick("premium")
                    }
                }
            }

        fun newsAdapterDelegate(newsItemClick: (String) -> Unit) =
            adapterDelegate(
                layout = R.layout.item_ad,
                on = { item: PostModel, items: List<PostModel>, position: Int ->
                    item.type == 2
                }
            ) {

                val newsText: TextView = findViewById(R.id.ad_text)
                val newsImage: ShapeableImageView = findViewById(R.id.ad_image)

                bind { diffPayloads ->
                    newsText.text = item.text
                    newsImage.setImageResource(item.image)

                    newsImage.setOnClickListener {
                        newsItemClick("news")
                    }
                }
            }

        //        fun newsAdapterDelegateWithBinding(onNewsItemClick: (String) -> Unit) =
//            adapterDelegateViewBinding<PostModel, PostModel, ItemAdBinding>(
//                { layoutInflater, parent ->
//                    ItemAdBinding.inflate(
//                        layoutInflater,
//                        parent,
//                        false
//                    )
//                }
//            ) {
//                binding.adText.text = "Ad text - " + item.text
//            }

        val adapter = ListDelegationAdapter(
            postAdapterDelegate {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            },
            premiumPostAdapterDelegate {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            },
            bannersAdapterDelegate(),
            newsAdapterDelegate {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        )
        adapter.items = fakeData
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

    }
}