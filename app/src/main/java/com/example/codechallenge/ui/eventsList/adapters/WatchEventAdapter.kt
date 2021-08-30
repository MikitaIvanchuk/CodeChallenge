package com.example.codechallenge.ui.eventsList.adapters

import com.example.codechallenge.databinding.WatchEventItemBinding
import com.example.codechallenge.model.watchEvent.WatchEventModel
import com.example.codechallenge.utils.delegateAdapter.BaseAdapter
import com.example.codechallenge.utils.delegateAdapter.OnItemClickListener
import com.example.codechallenge.utils.loadImage

class WatchEventAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseAdapter<WatchEventModel, WatchEventItemBinding>(WatchEventItemBinding::inflate) {
    override fun WatchEventItemBinding.onBind(item: WatchEventModel) {
        eventId.text = item.id
        eventName.text = item.type.value
        userName.text = item.actor.displayLogin
        watchEventAction.text = item.watchEventPayload.action
        userProfileImage.loadImage(item.actor.avatarUrl)

        watchEventLayout.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is WatchEventModel

    override fun WatchEventModel.getItemId(): Any = type

}
