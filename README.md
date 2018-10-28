# TimeXt-Kotlin - develop branch

[![Platform](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)
<a target="_blank" href="https://android-arsenal.com/api?level=14" title="API14+"><img src="https://img.shields.io/badge/API-14+-blue.svg" /></a>
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
<a target="_blank" href="https://www.paypal.me/GuepardoApps" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-blue.svg" /></a>

[![Build](https://img.shields.io/badge/build-success-green.svg)](https://github.com/TimeXt/TimeXt-Kotlin/blob/develop/releases/lib-2018-10-28-1.aar)
[![Version](https://img.shields.io/badge/version-v0.2.0.181028-blue.svg)](https://github.com/TimeXt/TimeXt-Kotlin/tree/develop/releases/)
[![CodeCoverage](https://img.shields.io/badge/codeCoverage-71-orange.svg)](https://github.com/TimeXt/TimeXt-Kotlin/tree/develop/)

First of all many thanks to [Kizitonwose](https://github.com/kizitonwose/Time) for the original idea and already awesome library!

This library shall help to reduce code like...

```kotlin
val dayInMillis = 24 * 60 * 60 * 1000       // Represent a day in milliSeconds

```

... or allow code like

```kotlin
val date1 = java.sql.Date(1540719288642)
val date2 = java.sql.Date(1540722888642)

val difference = date2 - date1

```

## How to use

### Basics

```kotlin
// Type is TimeXt
val oneWeek = 1.weeks
val threeDays = 3.days
val elevenHours = 11.hours
val sixMinutes = 6.minutes
val fiftySeconds = 50.seconds
val hundredMilliseconds = 100.milliseconds

val oneDayInMillis = 1.days.inMilliSeconds  // Returns one day in milliseconds
val twoWeeksInHours = 2.weeks.inHours       // Returns two weeks in hours

// Converts the existing 3h-Class into a 180min-Class
val threeHoursToMinutes = 3.hours.toMinutes() 
// 3.hours === TimeXt(3, TimeXtUnit.hour)
// 180.minutes === TimeXt(180, TimeXtUnit.minute)

val duration = 1.days + 11.hours + 35.minutes + 15.seconds - 250.milliseconds
val multipliedDuration = 1.5 * duration
val dividedDuration = duration / 2

val isLessTrue = 1.days < 1.weeks           // True
val isLessFalse = 24.hours < 360.minutes    // False

val isBiggerTrue = 5.minutes > 30.seconds   // True
val isBiggerFalse = 500.minutes > 5.weeks   // False

```

### Extensions

```kotlin
// Calendar
val inOneHour = Calendar.getInstance() + 1.hours
val threeDaysAgo = Calendar.getInstance() - 3.days
val difference = calendar1 - calendar2      // you can perform minus on calendar and get a TimeXt-object

// Sql Date
var sqlDate: java.sql.Date = java.sql.Date()
sqlDate = sqlDate + 5.minutes
sqlDate = sqlDate - 30.seconds
val difference = sqlDate1 - sqlDate2        // you can perform minus on java.sql.Date and get a TimeXt-object

// Util Date
val utilDate: java.util.Date = java.util.Date()
utilDate = utilDate + 5.minutes
utilDate = utilDate - 30.seconds
val difference = utilDate1 - utilDate2      // you can perform minus on java.util.Date and get a TimeXt-object

// Timer
val timer = Timer()
timer.schedule(10.seconds) {
    println("This block will be called in 10 seconds")
}
```

The library also includes extensions for Android's Handler class, this is only available if you compile the "timext-android" module.

```kotlin
val handler = Handler()
handler.postDelayed({
    Log.i("TAG", "This will be printed to the Logcat in 2 minutes")
}, 2.minutes)
```

### Custom TimeXtUnit

If you would like to have your own timext unit, implement it as followed:

```kotlin
val year: Double = 365 * 24 * 60 * 60 * 1e3

// Add also some extensions:
val Number.years: TimeXt
    get() = TimeXt(this.toDouble(), year)

val TimeXt.inYears: TimeXt
    get() = this.value * this.unit / year

fun toYears(): TimeXt {
    return TimeXt(this.inYears, year)
}

// Use it like:
val threeYears = TimeXt(3, year)
val oneYear = 1.years
val daysInYear = 365.days.inYears
val yearsFromDays = 365.days.toYears()

```

## Requirements

- Use at least JVM 1.8

## License

TimeXt-Kotlin is distributed under the MIT license. [See LICENSE](https://github.com/TimeXt/TimeXt-Kotlin/blob/develop/LICENSE.md) for details.
