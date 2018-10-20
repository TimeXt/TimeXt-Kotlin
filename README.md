# TimeXt-Kotlin - develop branch

[![Platform](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)
<a target="_blank" href="https://android-arsenal.com/api?level=14" title="API14+"><img src="https://img.shields.io/badge/API-14+-blue.svg" /></a>
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
<a target="_blank" href="https://www.paypal.me/GuepardoApps" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-blue.svg" /></a>

[![Build](https://img.shields.io/badge/build-success-green.svg)](https://github.com/TimeXt/TimeXt-Kotlin/blob/develop/releases/lib-2018-10-20-1.aar)
[![Version](https://img.shields.io/badge/version-v0.1.0.181020-blue.svg)](https://github.com/TimeXt/TimeXt-Kotlin/tree/develop/releases/)

First of all many thanks to [Kizitonwose](https://github.com/kizitonwose/Time) for the original idea and already awesome library!

This library shall help to reduce code like

```kotlin
val dayInMillis = 24 * 60 * 60 * 1000       // Represent a day in milliSeconds
```

## How to use

### Basics

```kotlin
val oneWeek = 1.weeks                       // Type is Interval<Week>
val threeDays = 3.days                      // Type is Interval<Day>
val elevenHours = 11.hours                  // Type is Interval<Hour>
val sixMinutes = 6.minutes                  // Type is Interval<Minute>
val fiftySeconds = 50.seconds               // Type is Interval<Second>
val hundredMilliSeconds = 100.milliSeconds  // Type is Interval<MilliSecond>
val fiveMicroSeconds = 5.microSeconds       // Type is Interval<MicroSecond>
val oneNanoSecond = 1.nanoSeconds           // Type is Interval<NanoSecond>
val onePicoSecond = 1.picoSeconds           // Type is Interval<PicoSecond>

val oneDayInMillis = 1.days.inMilliSeconds  // Converts one day into milliseconds
val twoWeeksInHours = 2.weeks.inHours       // Converts two weeks into hours

val duration = 1.days + 11.hours + 35.minutes + 15.seconds - 250.milliSeconds
val multipliedDuration = 1.5 * duration
val dividedDuration = duration / 2

val isLessTrue = 1.days < 1.weeks           // True
val isLessFalse = 24.hours < 360.minutes    // False

val isBiggerTrue = 5.minutes > 30.seconds   // True
val isBiggerFalse = 500.nanoSeconds > 1.minutes // False

```

### Extensions

```kotlin
// Calendar
val inOneHour = Calendar.getInstance() + 1.hours
val threeDaysAgo = Calendar.getInstance() - 3.days

// Sql Date
val sqlDate: java.sql.Date = java.sql.Date()
sqlDate + 5.minutes
sqlDate - 30.seconds

// Util Date
val utilDate: java.util.Date = java.util.Date()
utilDate + 5.minutes
utilDate - 30.seconds

// Timer
val timer = Timer()
timer.schedule(10.seconds) {
    println("This block will be called in 10 seconds")
}
```

The library also includes extensions for Android's Handler class, this is only available if you compile the "lib-android" module.

```kotlin
val handler = Handler()
handler.postDelayed({
    Log.i("TAG", "This will be printed to the Logcat in 2 minutes")
}, 2.minutes)
```

### Custom IDateTimeUnit

If you would like to have your own date time unit, implement it as followed:

```kotlin
class Year : IDateTimeUnit {
    // amount of seconds in one year
    override val dateTimeIntervalRatio = 365.0 * 24.0 * 60.0 * 60.0
}

// Add also some extensions:
val Number.years: Interval<Year>
    get() = Interval(this)

val Interval<IDateTimeUnit>.inYears: Interval<Year>
    get() = converted()

// Use it like:
val threeYears = Interval<Year>(3)
val oneYear = 1.years
val daysInYear = 365.days.inYears

```

## Requirements

- Use at least JVM 1.8

## License

TimeXt-Kotlin is distributed under the MIT license. [See LICENSE](https://github.com/TimeXt/TimeXt-Kotlin/blob/develop/LICENSE.md) for details.
