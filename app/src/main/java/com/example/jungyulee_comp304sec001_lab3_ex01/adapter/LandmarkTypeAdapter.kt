package com.example.jungyulee_comp304sec001_lab3_ex01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jungyulee_comp304sec001_lab3_ex01.databinding.ItemLandmarkTypeBinding
import com.example.jungyulee_comp304sec001_lab3_ex01.model.LandmarkType

class LandmarkTypeAdapter(private val landmarkTypes: List<LandmarkType>) :
    RecyclerView.Adapter<LandmarkTypeAdapter.LandmarkTypeViewHolder>() {
    var onItemClick: ((LandmarkType) -> Unit)? = null

    class LandmarkTypeViewHolder(val binding: ItemLandmarkTypeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkTypeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLandmarkTypeBinding.inflate(inflater, parent, false)
        return LandmarkTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkTypeViewHolder, position: Int) {
        val landmarkType = landmarkTypes[position]
        holder.binding.textViewLandmarkTypeName.text = landmarkType.name
        holder.itemView.setOnClickListener {
            // notifies the listener when an item is clicked
            onItemClick?.invoke(landmarkType)
        }
    }

    override fun getItemCount() = landmarkTypes.size
}