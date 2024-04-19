package com.technocenter.resourceTreatment.util

data class ConstantVar(
    // Existing Variables
    public val quadrant: Array<String> = arrayOf("Novice", "Challengers", "Hunter", "MVP"),
    public val nonQuadrant: Array<String> = arrayOf("Ungraded", "Junior", "Senior", "Consultant", "Resign", "Terminate")
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConstantVar

        if (!quadrant.contentEquals(other.quadrant)) return false
        if (!nonQuadrant.contentEquals(other.nonQuadrant)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = quadrant.contentHashCode()
        result = 31 * result + nonQuadrant.contentHashCode()
        return result
    }
}
