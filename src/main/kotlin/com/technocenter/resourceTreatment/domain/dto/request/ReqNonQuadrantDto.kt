package com.technocenter.resourceTreatment.domain.dto.request

data class ReqNonQuadrantDto(
    val hasMainJob: Boolean,
    val level: Int,
    val sprintNum: Int,
    val isResign: Boolean,
    val underPerform: Boolean
)