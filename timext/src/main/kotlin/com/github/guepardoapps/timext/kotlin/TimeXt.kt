package com.github.guepardoapps.timext.kotlin

class TimeXt(var value: Double, private var unit: Double) {

    val inCenturies: Double
        get() = this.value * this.unit / TimeXtUnit.century

    val inDecades: Double
        get() = this.value * this.unit / TimeXtUnit.decade

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

    val inMillis: Double
        get() = this.value * this.unit / TimeXtUnit.millisecond

    fun toCenturies(): TimeXt = TimeXt(this.inCenturies, TimeXtUnit.century)

    fun toDecades(): TimeXt = TimeXt(this.inDecades, TimeXtUnit.decade)

    fun toYears(): TimeXt = TimeXt(this.inYears, TimeXtUnit.year)

    fun toWeeks(): TimeXt = TimeXt(this.inWeeks, TimeXtUnit.week)

    fun toDays(): TimeXt = TimeXt(this.inDays, TimeXtUnit.day)

    fun toHours(): TimeXt = TimeXt(this.inHours, TimeXtUnit.hour)

    fun toMinutes(): TimeXt = TimeXt(this.inMinutes, TimeXtUnit.minute)

    fun toSeconds(): TimeXt = TimeXt(this.inSeconds, TimeXtUnit.second)

    fun toMillis(): TimeXt = TimeXt(this.inMillis, TimeXtUnit.millisecond)

    operator fun plus(timeXt: TimeXt): TimeXt = TimeXt(((this.inMillis + timeXt.inMillis) / this.unit) * TimeXtUnit.millisecond, this.unit)

    operator fun minus(timeXt: TimeXt): TimeXt = TimeXt(((this.inMillis - timeXt.inMillis) / this.unit) * TimeXtUnit.millisecond, this.unit)

    operator fun times(timesValue: Number): TimeXt = TimeXt(value * timesValue.toDouble(), this.unit)

    operator fun div(divValue: Number): TimeXt {
        if (divValue == 0) {
            throw ArithmeticException("Diversion value may not be 0!")
        }
        return TimeXt(value / divValue.toDouble(), this.unit)
    }

    operator fun inc() = TimeXt(value + 1, this.unit)

    operator fun dec() = TimeXt(value - 1, this.unit)

    operator fun compareTo(compareTimeXt: TimeXt) = inMillis.compareTo(compareTimeXt.inMillis)

    operator fun contains(compareTimeXt: TimeXt) = inMillis >= compareTimeXt.inMillis

    override operator fun equals(other: Any?): Boolean =
            if (other == null || other !is TimeXt) {
                false
            } else {
                compareTo(other) == 0
            }

    override fun hashCode() = inMillis.hashCode()
}