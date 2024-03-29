package com.example.jungyulee_comp304sec001_lab3_ex01.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jungyulee_comp304sec001_lab3_ex01.adapter.LandmarkListAdapter
import com.example.jungyulee_comp304sec001_lab3_ex01.databinding.ActivityLandmarkListBinding
import com.example.jungyulee_comp304sec001_lab3_ex01.model.Landmark

class LandmarkListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandmarkListBinding
    private lateinit var landmarks: List<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandmarkListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landmarks = intent.getParcelableArrayListExtra<Landmark>("landmarks") ?: listOf()

        binding.landmarksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.landmarksRecyclerView.adapter = LandmarkListAdapter(landmarks) { selectedLandmark ->
            val intent = Intent(this, MapsActivity::class.java).apply {
                putExtra("name", selectedLandmark.name)
                putExtra("latitude", selectedLandmark.latitude)
                putExtra("longitude", selectedLandmark.longitude)
            }
            startActivity(intent)
        }
    }
}