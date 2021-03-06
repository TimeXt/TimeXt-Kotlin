package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import java.util.*

fun Timer.schedule(task: TimerTask, period: TimeXt) = schedule(task, period.inMillis.toLong())

fun Timer.schedule(task: TimerTask, delay: TimeXt, period: TimeXt) = schedule(task, delay.inMillis.toLong(), period.inMillis.toLong())

fun Timer.schedule(task: TimerTask, firstTime: Date, period: TimeXt) = schedule(task, firstTime, period.inMillis.toLong())

fun Timer.scheduleAtFixedRate(task: TimerTask, delay: TimeXt, period: TimeXt) = scheduleAtFixedRate(task, delay.inMillis.toLong(), period.inMillis.toLong())

fun Timer.scheduleAtFixedRate(task: TimerTask, firstTime: Date, period: TimeXt) = scheduleAtFixedRate(task, firstTime, period.inMillis.toLong())