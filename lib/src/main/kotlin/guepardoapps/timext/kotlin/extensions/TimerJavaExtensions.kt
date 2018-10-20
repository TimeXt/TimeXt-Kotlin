package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval
import java.util.*

fun Timer.schedule(task: TimerTask, period: Interval<IDateTimeUnit>)
        = schedule(task, period.inMilliSeconds.value.toLong())

fun Timer.schedule(task: TimerTask, delay: Interval<IDateTimeUnit>, period: Interval<IDateTimeUnit>)
        = schedule(task, delay.inMilliSeconds.value.toLong(), period.inMilliSeconds.value.toLong())

fun Timer.schedule(task: TimerTask, firstTime: Date, period: Interval<IDateTimeUnit>)
        = schedule(task, firstTime, period.inMilliSeconds.value.toLong())

fun Timer.scheduleAtFixedRate(task: TimerTask, delay: Interval<IDateTimeUnit>, period: Interval<IDateTimeUnit>)
        = scheduleAtFixedRate(task, delay.inMilliSeconds.value.toLong(), period.inMilliSeconds.value.toLong())

fun Timer.scheduleAtFixedRate(task: TimerTask, firstTime: Date, period: Interval<IDateTimeUnit>)
        = scheduleAtFixedRate(task, firstTime, period.inMilliSeconds.value.toLong())