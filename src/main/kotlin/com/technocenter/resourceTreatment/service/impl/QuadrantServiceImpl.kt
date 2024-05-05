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
        result.quadrant = constVar.quadrantIndx[getIndex]
        result.name = constVar.quadrant[getIndex]

        return ResMessageDto(data = result)
    }

    override fun isNonQuadrantI(
        req: ReqNonQuadrantDto
    ): ResFinalMessageDto<ResNonQuadrantDto, ReqNonQuadrantDto, ResTreatmentDto> {
        val resultNQ = ResNonQuadrantDto("")
        val resultT = ResTreatmentDto("")
        var getNameIndex: Int = -1
        var getTreatmentIndex: Int = -1

        val lvErr = Err()
        lvErr.message = "Level cannot be < 0 or > 5"
        if (req.level < 0 || req.level > 5)
            throw InvalidAttributeValueException("Error: ${lvErr.message}\n")

        if (req.level < 3){
            getNameIndex = 1        // Junior
            getTreatmentIndex = 2   // Need-Assignment
        }
        if (req.level == 3){
            getNameIndex = 2        // Senior
            getTreatmentIndex = 1   // Maintain
        }
        if (req.level > 3){
            getNameIndex = 3        // Consultant
            getTreatmentIndex = 1   // Maintain
        }

        if (!req.hasMainJob){
            if (req.sprintNum < 7){
                getNameIndex = 0        // Ungraded
                getTreatmentIndex = 2   // Need-Assignment
            }
        }

        if (req.isResign){
            getNameIndex = 4        // Resign
            getTreatmentIndex = 9   // Resign
        }

        if (req.underPerform){
            getNameIndex = 5        // Terminate
            getTreatmentIndex = 0   // Terminate
        }

        if (getNameIndex == -1 || getTreatmentIndex == -1)
            throw InvalidAttributeValueException("Error: Level is not defined\n")

        resultNQ.name = constVar.nonQuadrant[getNameIndex]
        resultT.name = constVar.treatments[getTreatmentIndex]

        return ResFinalMessageDto(
            200, "Success",
            null, resultNQ, req, resultT
        )
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