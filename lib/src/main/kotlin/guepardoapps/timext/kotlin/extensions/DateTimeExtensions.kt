package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval

operator fun java.sql.Date.plus(dateTimeUnit: Interval<IDateTimeUnit>) {
    this.time + dateTimeUnit.inMilliSeconds.value.toLong()
}

operator fun java.sql.Date.minus(dateTimeUnit: Interval<IDateTimeUnit>) {
    this + (dateTimeUnit * -1)
}

operator fun java.util.Date.plus(dateTimeUnit: Interval<IDateTimeUnit>) {
    this.time + dateTimeUnit.inMilliSeconds.value.toLong()
}

operator fun java.util.Date.minus(dateTimeUnit: Interval<IDateTimeUnit>) {
    this + (dateTimeUnit * -1)
}