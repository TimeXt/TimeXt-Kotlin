package guepardoapps.timext.kotlin.extensions

import android.os.Handler
import guepardoapps.timext.kotlin.IDateTimeUnit
import guepardoapps.timext.kotlin.Interval

fun Handler.postDelayed(runnable: Runnable, delay: Interval<IDateTimeUnit>)
        = postDelayed(runnable, delay.inMilliSeconds.value.toLong())

fun Handler.postDelayed(runnable: () -> Unit, delay: Interval<IDateTimeUnit>)
        = postDelayed(runnable, delay.inMilliSeconds.value.toLong())