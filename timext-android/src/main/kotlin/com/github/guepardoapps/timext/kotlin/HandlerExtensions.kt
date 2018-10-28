package com.github.guepardoapps.timext.kotlin

import android.os.Handler

fun Handler.postDelayed(runnable: Runnable, delay: TimeXt) = postDelayed(runnable, delay.inMilliseconds.toLong())

fun Handler.postDelayed(runnable: () -> Unit, delay: TimeXt) = postDelayed(runnable, delay.inMilliseconds.toLong())