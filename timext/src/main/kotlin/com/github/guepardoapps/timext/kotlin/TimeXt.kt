package com.github.guepardoapps.timext.kotlin

class TimeXt(var value: Double, private var unit: Double) {

    val inYears: Double
        get() = this.value * this.unit / TimeXtUnit.year

    val inWeeks: Double
        get() = this.value * this.unit / TimeXtUnit.week

    val inDays: Double
        get() = this.value * this.unit / TimeXtUnit.day

    val inHours: Double
        get() = this.value * this.unit / TimeXtUnit.hour

    val inMinutes: Double
        get() = this.value * this.unit / TimeXtUnit.minute

    val inSeconds: Double
        get() = this.value * this.unit / TimeXtUnit.second

    val inMilliseconds: Double
        get() = this.value * this.unit / TimeXtUnit.millisecond

    fun toYears(): TimeXt = TimeXt(this.inYears, TimeXtUnit.year)

    fun toWeeks(): TimeXt = TimeXt(this.inWeeks, TimeXtUnit.week)

    fun toDays(): TimeXt = TimeXt(this.inDays, TimeXtUnit.day)

    fun toHours(): TimeXt = TimeXt(this.inHours, TimeXtUnit.hour)

    fun toMinutes(): TimeXt = TimeXt(this.inMinutes, TimeXtUnit.minute)

    fun toSeconds(): TimeXt = TimeXt(this.inSeconds, TimeXtUnit.second)

    fun toMilliseconds(): TimeXt = TimeXt(this.inMilliseconds, TimeXtUnit.millisecond)

    operator fun plus(timeXt: TimeXt): TimeXt = TimeXt(((this.inMilliseconds + timeXt.inMilliseconds) / this.unit) * TimeXtUnit.millisecond, this.unit)

    operator fun minus(timeXt: TimeXt): TimeXt = TimeXt(((this.inMilliseconds - timeXt.inMilliseconds) / this.unit) * TimeXtUnit.millisecond, this.unit)

    operator fun times(timesValue: Number): TimeXt = TimeXt(value * timesValue.toDouble(), this.unit)

    operator fun div(divValue: Number): TimeXt {
        if (divValue == 0) {
            throw ArithmeticException("Diversion value may not be 0!")
        }
        return TimeXt(value / divValue.toDouble(), this.unit)
    }

    operator fun inc() = TimeXt(value + 1, this.unit)

    operator fun dec() = TimeXt(value - 1, this.unit)

    operator fun compareTo(compareTimeXt: TimeXt) = inMilliseconds.compareTo(compareTimeXt.inMilliseconds)

    operator fun contains(compareTimeXt: TimeXt) = inMilliseconds >= compareTimeXt.inMilliseconds

    override operator fun equals(other: Any?): Boolean =
            if (other == null || other !is TimeXt) {
                false
            } else {
                compareTo(other) == 0
            }

    override fun hashCode() = inMilliseconds.hashCode()
}