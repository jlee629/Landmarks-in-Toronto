package com.example.jungyulee_comp304sec001_lab3_ex01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jungyulee_comp304sec001_lab3_ex01.databinding.ItemLandmarkBinding
import com.example.jungyulee_comp304sec001_lab3_ex01.model.Landmark

class LandmarkListAdapter(
    private val landmarks: List<Landmark>,
    private val onItemClick: (Landmark) -> Unit
) : RecyclerView.Adapter<LandmarkListAdapter.LandmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLandmarkBinding.inflate(inflater, parent, false)
        return LandmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        val landmark = landmarks[position]
        with(holder.binding) {
            textViewName.text = landmark.name
            textViewAddress.text = landmark.address
            root.setOnClickListener {
                onItemClick(landmark)
            }
        }
    }

    override fun getItemCount() = landmarks.size

    class LandmarkViewHolder(val binding: ItemLandmarkBinding) : RecyclerView.ViewHolder(binding.root)
}

