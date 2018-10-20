package guepardoapps.timext.kotlin.extensions

import guepardoapps.timext.kotlin.*

val Number.weeks: Interval<Week>
    get() = Interval(this)

val Number.days: Interval<Day>
    get() = Interval(this)

val Number.hours: Interval<Hour>
    get() = Interval(this)

val Number.minutes: Interval<Minute>
    get() = Interval(this)

val Number.seconds: Interval<Second>
    get() = Interval(this)

val Number.milliSeconds: Interval<MilliSecond>
    get() = Interval(this)

val Number.microSeconds: Interval<MicroSecond>
    get() = Interval(this)

val Number.nanoSeconds: Interval<NanoSecond>
    get() = Interval(this)

val Number.picoSeconds: Interval<PicoSecond>
    get() = Interval(this)
