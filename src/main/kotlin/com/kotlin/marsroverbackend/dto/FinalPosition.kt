package com.kotlin.marsroverbackend.dto

data class FinalPosition (
    var finalPosition: Position
)

fun finalPosition(position: Position):FinalPosition {
    return FinalPosition(position)
}
