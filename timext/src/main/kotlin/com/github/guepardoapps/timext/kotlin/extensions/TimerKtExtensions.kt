package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

inline fun Timer.schedule(delay: TimeXt, crossinline action: TimerTask.() -> Unit) = schedule(delay.inMillis.toLong(), action)

inline fun Timer.schedule(delay: TimeXt, period: TimeXt, crossinline action: TimerTask.() -> Unit) = schedule(delay.inMillis.toLong(), period.inMillis.toLong(), action)

inline fun Timer.schedule(time: Date, period: TimeXt, crossinline action: TimerTask.() -> Unit) = schedule(time, period.inMillis.toLong(), action)

inline fun Timer.scheduleAtFixedRate(delay: TimeXt, period: TimeXt, crossinline action: TimerTask.() -> Unit) = scheduleAtFixedRate(delay.inMillis.toLong(), period.inMillis.toLong(), action)

inline fun Timer.scheduleAtFixedRate(time: Date, period: TimeXt, crossinline action: TimerTask.() -> Unit) = scheduleAtFixedRate(time, period.inMillis.toLong(), action)