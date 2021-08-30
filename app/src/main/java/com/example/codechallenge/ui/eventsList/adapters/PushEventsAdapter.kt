package com.example.codechallenge.ui.eventsList.adapters

import com.example.codechallenge.databinding.PushEventItemBinding
import com.example.codechallenge.model.pushEvent.PushEventModel
import com.example.codechallenge.utils.delegateAdapter.BaseAdapter
import com.example.codechallenge.utils.delegateAdapter.OnItemClickListener
import com.example.codechallenge.utils.loadImage

class PushEventsAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseAdapter<PushEventModel, PushEventItemBinding>(PushEventItemBinding::inflate) {

    override fun PushEventItemBinding.onBind(item: PushEventModel) {
        eventId.text = item.id
        eventName.text = item.type.value
        userName.text = item.actor.displayLogin
        pushEventHead.text = item.pushEventPayload.head
        userProfileImage.loadImage(item.actor.avatarUrl)

        pushEventLayout.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PushEventModel

    override fun PushEventModel.getItemId(): Any = type

}
