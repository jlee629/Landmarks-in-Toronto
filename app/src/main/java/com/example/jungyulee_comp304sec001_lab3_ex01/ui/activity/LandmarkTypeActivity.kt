package com.example.jungyulee_comp304sec001_lab3_ex01.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jungyulee_comp304sec001_lab3_ex01.adapter.LandmarkTypeAdapter
import com.example.jungyulee_comp304sec001_lab3_ex01.databinding.ActivityMainBinding
import com.example.jungyulee_comp304sec001_lab3_ex01.utils.loadLandmarksFromAssets

class LandmarkTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val landmarkTypes = loadLandmarksFromAssets(this)

        val adapter = LandmarkTypeAdapter(landmarkTypes)
        binding.landmarkTypeRecyclerView.adapter = adapter

        adapter.onItemClick = { landmarkType ->
            val intent = Intent(this, LandmarkListActivity::class.java).apply {
                // directly pass the selected landmark type's landmarks to the next activity
                putParcelableArrayListExtra("landmarks", ArrayList(landmarkType.landmarks))
            }
            startActivity(intent)
        }
    }
}

