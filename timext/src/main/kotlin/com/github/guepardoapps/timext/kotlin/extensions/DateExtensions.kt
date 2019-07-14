package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import com.github.guepardoapps.timext.kotlin.TimeXtUnit

operator fun java.sql.Date.plus(timeXt: TimeXt): java.sql.Date {
    this.time += timeXt.inMillis.toLong()
    return this
}

operator fun java.sql.Date.minus(timeXt: TimeXt): java.sql.Date {
    this.time -= timeXt.inMillis.toLong()
    return this
}

operator fun java.sql.Date.minus(date: java.sql.Date): TimeXt {
    val difference = this.time - date.time
    return TimeXt(difference.toDouble(), TimeXtUnit.millisecond)
}

operator fun java.util.Date.plus(timeXt: TimeXt): java.util.Date {
    this.time += timeXt.inMillis.toLong()
    return this
}

operator fun java.util.Date.minus(timeXt: TimeXt): java.util.Date {
    this.time -= timeXt.inMillis.toLong()
    return this
}

operator fun java.util.Date.minus(date: java.util.Date): TimeXt {
    val difference = this.time - date.time
    return TimeXt(difference.toDouble(), TimeXtUnit.millisecond)
}