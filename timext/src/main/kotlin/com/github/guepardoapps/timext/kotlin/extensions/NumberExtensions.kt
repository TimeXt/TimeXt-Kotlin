package com.github.guepardoapps.timext.kotlin.extensions

import com.github.guepardoapps.timext.kotlin.TimeXt
import com.github.guepardoapps.timext.kotlin.TimeXtUnit

val Number.centuries: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.century)

val Number.decades: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.decade)

val Number.years: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.year)

val Number.weeks: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.week)

val Number.days: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.day)

val Number.hours: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.hour)

val Number.minutes: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.minute)

val Number.seconds: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.second)

val Number.millis: TimeXt
    get() = TimeXt(this.toDouble(), TimeXtUnit.millisecond)
