package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import com.github.guepardoapps.timext.kotlin.TimeXtUnit
import java.util.*

operator fun Calendar.plus(timeXt: TimeXt): Calendar {
    val newCalendar = clone() as Calendar
    newCalendar.add(Calendar.MILLISECOND, timeXt.inMilliseconds.toInt())
    return newCalendar
}

operator fun Calendar.minus(timeXt: TimeXt): Calendar {
    return this + (timeXt * -1)
}

operator fun Calendar.minus(calendar: Calendar): TimeXt {
    val difference = this.timeInMillis - calendar.timeInMillis
    return TimeXt(difference.toDouble(), TimeXtUnit.millisecond)
}
