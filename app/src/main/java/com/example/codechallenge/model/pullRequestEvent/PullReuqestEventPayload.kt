package com.example.codechallenge.model.pullRequestEvent

import com.google.gson.annotations.SerializedName

data class PullRequestEventPayload(
    val action: String,
    val number: Int,
    @SerializedName("pull_request")
    val pullRequest: PullRequest
)
