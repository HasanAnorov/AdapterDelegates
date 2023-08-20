package com.hasan.adapterdelegates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hasan.adapterdelegates.databinding.ActivityMainBinding
import com.hasan.adapterdelegates.model.PostModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fakeData = arrayOf<PostModel>(
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 2"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 1"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 3"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 4"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 5"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 6"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 7"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 8"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 9"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 10"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 11"),
//            PostModel(PostType.PREMIUM_POST, R.drawable.ic_launcher_foreground, "Test text 12"),
//            PostModel(PostType.PREMIUM_POST, R.drawable.ic_launcher_foreground, "Test text 13"),
//            PostModel(PostType.PREMIUM_POST, R.drawable.ic_launcher_foreground, "Test text 14"),
//            PostModel(PostType.POST,R.drawable.ic_launcher_foreground, "Test text 15")
        )

//        val postAdapter = PostAdapter(
//            dataSet = fakeData,
//            itemClick = {
//                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//            },
//            premiumItemClick = {
//                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//            }
//        )
//
//        val recyclerView: RecyclerView = binding.recyclerView
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recyclerView.adapter = postAdapter

    }
}