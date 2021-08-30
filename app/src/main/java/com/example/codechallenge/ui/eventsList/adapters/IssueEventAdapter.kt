package com.example.codechallenge.ui.eventsList.adapters

import com.example.codechallenge.databinding.IssueEventItemBinding
import com.example.codechallenge.model.createEvent.CreateEventModel
import com.example.codechallenge.model.issueEvent.IssueEventModel
import com.example.codechallenge.utils.delegateAdapter.BaseAdapter
import com.example.codechallenge.utils.delegateAdapter.OnItemClickListener
import com.example.codechallenge.utils.loadImage

class IssueEventAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseAdapter<IssueEventModel, IssueEventItemBinding>(IssueEventItemBinding::inflate) {
    override fun IssueEventItemBinding.onBind(item: IssueEventModel) {
        eventId.text = item.id
        eventName.text = item.type.value
        userName.text = item.actor.displayLogin
        repositoryId.text = item.repo.id.toString()
        issueEventAction.text = item.issueEventPayload.action
        userProfileImage.loadImage(item.actor.avatarUrl)

        issueEventLayout.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is CreateEventModel

    override fun IssueEventModel.getItemId(): Any = type

}
