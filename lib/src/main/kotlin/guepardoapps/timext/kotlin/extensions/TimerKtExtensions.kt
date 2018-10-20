package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

inline fun Timer.schedule(delay: Interval<IDateTimeUnit>, crossinline action: TimerTask.() -> Unit)
        = schedule(delay.inMilliSeconds.value.toLong(), action)

inline fun Timer.schedule(delay: Interval<IDateTimeUnit>, period: Interval<IDateTimeUnit>, crossinline action: TimerTask.() -> Unit)
        = schedule(delay.inMilliSeconds.value.toLong(), period.inMilliSeconds.value.toLong(), action)

inline fun Timer.schedule(time: Date, period: Interval<IDateTimeUnit>, crossinline action: TimerTask.() -> Unit)
        = schedule(time, period.inMilliSeconds.value.toLong(), action)

inline fun Timer.scheduleAtFixedRate(delay: Interval<IDateTimeUnit>, period: Interval<IDateTimeUnit>, crossinline action: TimerTask.() -> Unit)
        = scheduleAtFixedRate(delay.inMilliSeconds.value.toLong(), period.inMilliSeconds.value.toLong(), action)

inline fun Timer.scheduleAtFixedRate(time: Date, period: Interval<IDateTimeUnit>, crossinline action: TimerTask.() -> Unit)
        = scheduleAtFixedRate(time, period.inMilliSeconds.value.toLong(), action)