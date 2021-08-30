package com.example.codechallenge.ui.eventDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.databinding.DetailsItemBinding
import com.example.codechallenge.model.DetailsModel
import com.example.codechallenge.model.Params

class EventDetailsAdapter(private val detailsList: DetailsModel) :
    RecyclerView.Adapter<EventDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventDetailsViewHolder {
        val binding = DetailsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return EventDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventDetailsViewHolder, position: Int) {
        holder.bind(detailsList.params[position])
    }

    override fun getItemCount(): Int =
        detailsList.params.size

}

class EventDetailsViewHolder(private val binding: DetailsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(params: Params) {
        binding.eventFieldName.text = params.name
        binding.eventFieldInfo.text = params.value
    }

}
