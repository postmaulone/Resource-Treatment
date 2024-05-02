package com.technocenter.resourceTreatment.domain.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

data class ResFinalMessageDto<Q,R,S>(
    val status: Int = 200,
    val message: String = "Success",

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val isQuadrant: Q? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val isNonQuadrant: Q? = null,
    val data: R? = null,
    val treatment: S? = null
)