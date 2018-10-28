package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt

fun Thread.sleep(timeXt: TimeXt) = Thread.sleep(timeXt.inMilliseconds.toLong())