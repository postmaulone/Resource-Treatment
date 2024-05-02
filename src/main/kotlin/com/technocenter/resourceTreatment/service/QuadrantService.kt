package com.technocenter.resourceTreatment.service

import com.technocenter.resourceTreatment.domain.dto.request.ReqNonQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.request.ReqQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.response.ResMessageDto
import com.technocenter.resourceTreatment.domain.dto.response.ResNonQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.response.ResQuadrantDto

interface QuadrantService {
    fun isQuadrantI(req: ReqQuadrantDto): ResMessageDto<ResQuadrantDto>
    fun isNonQuadrantI(req: ReqNonQuadrantDto): ResMessageDto<ResNonQuadrantDto>
}