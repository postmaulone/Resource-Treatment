package com.technocenter.resourceTreatment.domain.entity

import com.technocenter.resourceTreatment.domain.dto.request.ReqMvpDto
import jakarta.persistence.*


data class SummaryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary")
    val id: Int,

    val data: ReqMvpDto,
)
