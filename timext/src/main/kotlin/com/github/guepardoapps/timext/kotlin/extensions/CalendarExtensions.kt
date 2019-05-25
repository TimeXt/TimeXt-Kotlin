package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import com.github.guepardoapps.timext.kotlin.TimeXtUnit
import java.util.*

operator fun Calendar.plus(timeXt: TimeXt): Calendar {
    val newCalendar = clone() as Calendar
    newCalendar.timeInMillis += timeXt.inMilliseconds.toLong()
    return newCalendar
}

operator fun Calendar.minus(timeXt: TimeXt): Calendar = this + (timeXt * -1)

operator fun Calendar.minus(calendar: Calendar): TimeXt = TimeXt((this.timeInMillis - calendar.timeInMillis).toDouble(), TimeXtUnit.millisecond)
