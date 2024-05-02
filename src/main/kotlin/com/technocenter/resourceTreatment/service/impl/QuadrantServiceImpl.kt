package com.technocenter.resourceTreatment.service.impl

import com.technocenter.resourceTreatment.domain.dto.request.*
import com.technocenter.resourceTreatment.domain.dto.response.*
import com.technocenter.resourceTreatment.service.QuadrantService
import com.technocenter.resourceTreatment.util.ConstantVariable
import org.springframework.stereotype.Service
import javax.management.InvalidAttributeValueException

@Service
class QuadrantServiceImpl(
    val constVar: ConstantVariable
): QuadrantService {
    class Err{
        var error: Boolean = false
        var message: String? = null
    }
    override fun isQuadrantI(req: ReqQuadrantDto): ResMessageDto<ResQuadrantDto> {
        val compErr = Err()
        compErr.message = "Competency cannot be < 1 or > 5"
        val perfErr = Err()
        perfErr.message = "Performance cannot be < 50 or > 100"

        if (req.competency < 1 || req.competency > 5)
            compErr.error = true
        if(req.performance < 0 || req.performance > 100)
            perfErr.error = true

        if(compErr.error && perfErr.error)
            throw InvalidAttributeValueException("Error:\n1. ${compErr.message}\n2. ${perfErr.message}")
        if(compErr.error)
            throw InvalidAttributeValueException("Error: ${compErr.message}\n")
        if(perfErr.error)
            throw InvalidAttributeValueException("Error: ${perfErr.message}\n")

        val result = ResQuadrantDto("", "")
        val getIndex: Int = if (req.competency < 4){
            if (req.performance < 51)
                0 // I, Novice
            else
                1 // II, Challenger
        }else{
            if (req.performance < 51)
                2 // III, Hunter
            else
                3 // IV, MVP
        }
        result.quadrant = constVar.quadrant[getIndex]
        result.quadrant = constVar.quadrant[getIndex]

        return ResMessageDto(data = result)
    }

    override fun isNonQuadrantI(req: ReqNonQuadrantDto): ResMessageDto<ResNonQuadrantDto> {
        val result = ResNonQuadrantDto("")

        val lvErr = Err()
        lvErr.message = "Level cannot be < 0 or > 5"
        if (req.level < 0 || req.level > 5)
            throw InvalidAttributeValueException("Error: ${lvErr.message}\n")

        if (req.level < 3)
            result.name = constVar.nonQuadrant[1]       // Junior
        if (req.level == 3)
            result.name = constVar.nonQuadrant[2]       // Senior
        if (req.level > 3)
            result.name = constVar.nonQuadrant[3]       // Consultant

        if (!req.hasMainJob){
            if (req.sprintNum < 7)
                result.name = constVar.nonQuadrant[0]   // Ungraded
        }

        if (req.isResign)
            result.name = constVar.nonQuadrant[4]       // Resign

        if (req.underPerform)
            result.name = constVar.nonQuadrant[5]       // Terminate

        return ResMessageDto(data = result)
    }

//    override fun isQuadrant(req: ReqQuadrantDto): ResFinalMessageDto<ResQuadrantDto,ResQuadrantDto,ResQuadrantDto> {
//        val objek = ResQuadrantDto(
//            "satu", "dua"
//        )
//        return ResFinalMessageDto(
//            200, "Success",
//            null, objek, objek, null,
//        )
//    }

}