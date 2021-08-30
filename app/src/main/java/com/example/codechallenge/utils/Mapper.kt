package com.example.codechallenge.utils

import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.model.DetailsModel
import com.example.codechallenge.model.Params
import com.example.codechallenge.model.createEvent.CreateEventModel
import com.example.codechallenge.model.issueEvent.IssueEventModel
import com.example.codechallenge.model.pullRequestEvent.PullRequestEventModel
import com.example.codechallenge.model.pushEvent.PushEventModel
import com.example.codechallenge.model.watchEvent.WatchEventModel

object Mapper {
    fun mapToUIModel(model: BaseEventModel): DetailsModel? {
        return when (model) {
            is PushEventModel -> DetailsModel(
                params = listOf(
                    Params(
                        name = "HEAD",
                        value = model.pushEventPayload.head
                    ),
                    Params(
                        name = "BEFORE",
                        value = model.pushEventPayload.before
                    ),
                    Params(
                        name = "REF",
                        value = model.pushEventPayload.ref
                    ),
                    Params(
                        name = "SIZE",
                        value = model.pushEventPayload.size.toString()
                    ),
                    Params(
                        name = "PUSH ID",
                        value = model.pushEventPayload.pushId.toString()
                    ),
                    Params(
                        name = "DISTINCT SIZE",
                        value = model.pushEventPayload.distinctSize.toString()
                    )
                )
            )
            is PullRequestEventModel -> DetailsModel(
                params = listOf(
                    Params(
                        name = "ACTION",
                        value = model.pullRequestEventPayload.action
                    ),
                    Params(
                        name = "NUMBER",
                        value = model.pullRequestEventPayload.number.toString()
                    ),
                    Params(
                        name = "AUTHOR ASSOCIATION",
                        value = model.pullRequestEventPayload.pullRequest.authorAssociation
                    ),
                    Params(
                        name = "CREATED AT",
                        value = model.pullRequestEventPayload.pullRequest.createdAt
                    ),
                    Params(
                        name = "MERGEABLE STATE",
                        value = model.pullRequestEventPayload.pullRequest.mergeableState
                    ),
                    Params(
                        name = "TITLE",
                        value = model.pullRequestEventPayload.pullRequest.title
                    )
                )
            )
            is CreateEventModel -> DetailsModel(
                params = listOf(
                    Params(
                        name = "DESCRIPTION",
                        value = model.createEventPayload.description
                    ),
                    Params(
                        name = "MASTER BRANCH",
                        value = model.createEventPayload.masterBranch
                    ),
                    Params(
                        name = "PUSHER TYPE",
                        value = model.createEventPayload.pusherType
                    ),
                    Params(
                        name = "REF",
                        value = model.createEventPayload.ref
                    ),
                    Params(
                        name = "REF TYPE",
                        value = model.createEventPayload.refType
                    )
                )
            )
            is IssueEventModel -> DetailsModel(
                params = listOf(
                    Params(
                        name = "ACTION",
                        value = model.issueEventPayload.action
                    ),
                    Params(
                        name = "AUTHOR ASSOCIATION",
                        value = model.issueEventPayload.issue.authorAssociation
                    ),
                    Params(
                        name = "BODY",
                        value = model.issueEventPayload.issue.body
                    ),
                    Params(
                        name = "NODE ID",
                        value = model.issueEventPayload.issue.nodeId
                    ),
                    Params(
                        name = "STATE",
                        value = model.issueEventPayload.issue.state
                    ),
                    Params(
                        name = "TITLE",
                        value = model.issueEventPayload.issue.title
                    )
                )
            )
            is WatchEventModel -> DetailsModel(
                params = listOf(
                    Params(
                        name = "ACTION",
                        value = model.watchEventPayload.action
                    )
                )
            )
            else -> null
        }
    }
}
