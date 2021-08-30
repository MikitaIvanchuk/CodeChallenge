package com.example.codechallenge.model.issueEvent

data class IssueEventPayload(
    val action: String,
    val issue: Issue
)
