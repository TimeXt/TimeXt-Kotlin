package guepardoapps.timext.kotlin

class Interval<out T : IDateTimeUnit>(value: Number, val factory: () -> T) {

    val value = value.toDouble()

    companion object {
        inline operator fun <reified K : IDateTimeUnit> invoke(value: Number) = Interval(value) {
            K::class.java.newInstance()
        }
    }

    val inWeeks: Interval<Week>
        get() = converted()

    val inDays: Interval<Day>
        get() = converted()

    val inHours: Interval<Hour>
        get() = converted()

    val inMinutes: Interval<Minute>
        get() = converted()

    val inSeconds: Interval<Second>
        get() = converted()

    val inMilliSeconds: Interval<MilliSecond>
        get() = converted()

    val inMicroSeconds: Interval<MicroSecond>
        get() = converted()

    val inNanoSeconds: Interval<NanoSecond>
        get() = converted()

    val inPicoSeconds: Interval<PicoSecond>
        get() = converted()

    inline fun <reified ConversionUnit : IDateTimeUnit> converted(): Interval<ConversionUnit> {
        return Interval(value * factory().conversionRate(ConversionUnit::class.java.newInstance()))
    }

    operator fun plus(addInterval: Interval<IDateTimeUnit>): Interval<T> {
        return Interval(value + addInterval.value * addInterval.factory().conversionRate(factory())) { factory() }
    }

    operator fun minus(minusInterval: Interval<IDateTimeUnit>): Interval<T> {
        return Interval(value - minusInterval.value * minusInterval.factory().conversionRate(factory())) { factory() }
    }

    operator fun times(timesValue: Number): Interval<T> {
        return Interval(value * timesValue.toDouble()) { factory() }
    }

    operator fun div(diversionValue: Number): Interval<T> {
        if (diversionValue == 0) {
            throw ArithmeticException("Diversion value may not be 0!")
        }
        return Interval(value / diversionValue.toDouble()) { factory() }
    }

    operator fun inc() = Interval(value + 1) { factory() }

    operator fun dec() = Interval(value - 1) { factory() }

    operator fun compareTo(compareInterval: Interval<IDateTimeUnit>) = inNanoSeconds.value.compareTo(compareInterval.inNanoSeconds.value)

    operator fun contains(containsInterval: Interval<IDateTimeUnit>) = inMilliSeconds.value >= containsInterval.inMilliSeconds.value

    override operator fun equals(other: Any?): Boolean {
        if (other == null || other !is Interval<IDateTimeUnit>) {
            return false
        }
        return compareTo(other) == 0
    }

    override fun hashCode() = inMilliSeconds.value.hashCode()
}
