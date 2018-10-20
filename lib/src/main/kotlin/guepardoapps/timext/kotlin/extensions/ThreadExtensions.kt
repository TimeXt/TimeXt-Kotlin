package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval

fun Thread.sleep(interval: Interval<IDateTimeUnit>)
        = Thread.sleep(interval.inMilliSeconds.value.toLong())