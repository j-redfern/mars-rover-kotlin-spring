package com.kotlin.marsroverbackend.fixtures

import com.kotlin.marsroverbackend.dto.FormContents

class FormDto {
    companion object {
        fun createForm (
            plateauX : String?,
            plateauY : String?,
            startX : String? ,
            startY : String? ,
            direction : String? ,
            commands : String ,
        ): FormContents {
            return FormContents( plateauX, plateauY, startX, startY, direction, commands)
        }
    }
}

