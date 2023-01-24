package com.kotlin.marsroverbackend.fixtures

import com.kotlin.marsroverbackend.dto.Position

class PositionDto {
    companion object {
        fun createPosition(
            x: String,
            y: String,
        ): Position {
            return Position(x, y)
        }
    }
}
