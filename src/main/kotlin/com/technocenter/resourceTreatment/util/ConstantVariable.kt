package com.technocenter.resourceTreatment.util

import org.springframework.context.annotation.Configuration

@Configuration
class ConstantVariable {
    public val quadrant: Array<String> = arrayOf(
        "Novice", "Challengers", "Hunter", "MVP"
    )
    public val quadrantIndx: Array<String> = arrayOf(
        "I", "II", "III", "IV"
    )
    public val nonQuadrant: Array<String> = arrayOf(
        "Ungraded", "Junior", "Senior", "Consultant", "Resign", "Terminate"
    )
    public val treatments: Array<String> = arrayOf(
        "Terminate", "Maintain", "Need-Assignment",
        "Up-Skill", "Re-Skill", "Add-Skill", "Add-Soft-Skill(Leadership)",
        "Park", "Resign"
    )
}