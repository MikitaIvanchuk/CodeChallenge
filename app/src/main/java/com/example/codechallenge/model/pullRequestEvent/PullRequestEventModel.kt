package com.example.codechallenge.model.pullRequestEvent

import com.example.codechallenge.model.Actor
import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.model.EventTypes
import com.example.codechallenge.model.Repo
import com.google.gson.annotations.SerializedName

data class PullRequestEventModel(
    override val actor: Actor,
    @SerializedName("created_at")
    override val createdAt: String,
    override val id: String,
    @SerializedName("payload")
    val pullRequestEventPayload: PullRequestEventPayload,
    @SerializedName("`public`")
    override val isPublic: Boolean,
    override val repo: Repo,
    override val type: EventTypes
) : BaseEventModel

