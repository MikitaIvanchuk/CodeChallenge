package com.example.codechallenge.ui.eventsList.adapters

import com.example.codechallenge.databinding.PullRequestEventItemBinding
import com.example.codechallenge.model.pullRequestEvent.PullRequestEventModel
import com.example.codechallenge.utils.delegateAdapter.BaseAdapter
import com.example.codechallenge.utils.delegateAdapter.OnItemClickListener
import com.example.codechallenge.utils.loadImage

class PullRequestEventAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseAdapter<PullRequestEventModel, PullRequestEventItemBinding>(PullRequestEventItemBinding::inflate) {

    override fun PullRequestEventItemBinding.onBind(item: PullRequestEventModel) {
        eventId.text = item.id
        eventName.text = item.type.value
        userName.text = item.actor.displayLogin
        pullRequestAction.text = item.pullRequestEventPayload.action
        userProfileImage.loadImage(item.actor.avatarUrl)

        pullRequestEventLayout.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PullRequestEventModel

    override fun PullRequestEventModel.getItemId(): Any = type

}
