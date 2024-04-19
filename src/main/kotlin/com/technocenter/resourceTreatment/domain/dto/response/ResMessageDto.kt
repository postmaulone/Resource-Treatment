package com.technocenter.resourceTreatment.domain.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

data class ResMessageDto<Q, N, D, T>(
    val status: Int = 200,
    val message: String = "Success",

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val isQuadrant: Q? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val isNonQuadrant: N? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: D? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val treatment: T? = null
)