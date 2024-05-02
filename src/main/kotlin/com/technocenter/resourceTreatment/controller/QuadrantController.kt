package com.technocenter.resourceTreatment.controller

import com.technocenter.resourceTreatment.domain.dto.request.ReqQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.response.ResFinalMessageDto
import com.technocenter.resourceTreatment.domain.dto.response.ResMessageDto
import com.technocenter.resourceTreatment.domain.dto.response.ResQuadrantDto
import com.technocenter.resourceTreatment.service.QuadrantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class QuadrantController(
    val service: QuadrantService
) {
    @PostMapping("/quadrant")
    fun quadrant(
        @RequestBody req: ReqQuadrantDto
    ): ResponseEntity<ResMessageDto<ResQuadrantDto>>{
        return ResponseEntity.ok(service.isQuadrantI(req))
    }
}