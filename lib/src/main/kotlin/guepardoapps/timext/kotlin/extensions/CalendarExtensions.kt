package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval
import java.util.*

operator fun Calendar.plus(dateTimeUnit: Interval<IDateTimeUnit>): Calendar {
    val newCalendar = clone() as Calendar
    newCalendar.add(Calendar.MILLISECOND, dateTimeUnit.inMilliSeconds.value.toInt())
    return newCalendar
}

operator fun Calendar.minus(dateTimeUnit: Interval<IDateTimeUnit>): Calendar {
    return this + (dateTimeUnit * -1)
}
