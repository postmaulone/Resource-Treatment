package com.technocenter.resourceTreatment.controller

import com.technocenter.resourceTreatment.domain.dto.request.ReqNonQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.request.ReqQuadrantDto
import com.technocenter.resourceTreatment.domain.dto.response.*
import com.technocenter.resourceTreatment.service.QuadrantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/api")
class QuadrantController(
    val service: QuadrantService
) {
    @PostMapping("/quadrant")
    fun quadrant(
        @RequestBody req: ReqQuadrantDto
    ): ResponseEntity<ResMessageDto<ResQuadrantDto>>{
        return ResponseEntity.ok(service.isQuadrantI(req))
    }
    @PostMapping("/non-quadrant")
    fun nonQuadrant(
        @RequestBody req: ReqNonQuadrantDto
    ): ResponseEntity<ResFinalMessageDto<ResNonQuadrantDto, ReqNonQuadrantDto, ResTreatmentDto>>{
        return ResponseEntity.ok(service.isNonQuadrantI(req))
    }
}