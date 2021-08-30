package com.example.codechallenge.ui.eventsList.adapters

import com.example.codechallenge.databinding.CreateEventItemBinding
import com.example.codechallenge.model.createEvent.CreateEventModel
import com.example.codechallenge.utils.delegateAdapter.BaseAdapter
import com.example.codechallenge.utils.delegateAdapter.OnItemClickListener
import com.example.codechallenge.utils.loadImage

class CreateEventAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseAdapter<CreateEventModel, CreateEventItemBinding>(CreateEventItemBinding::inflate) {
    override fun CreateEventItemBinding.onBind(item: CreateEventModel) {
        eventId.text = item.id
        eventName.text = item.type.value
        userName.text = item.actor.displayLogin
        repositoryId.text = item.repo.id.toString()
        pusherType.text = item.createEventPayload.pusherType
        userProfileImage.loadImage(item.actor.avatarUrl)

        createEventLayout.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is CreateEventModel

    override fun CreateEventModel.getItemId(): Any = type

}
