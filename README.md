# TimeXt-Kotlin

[![Platform](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-14+-blue.svg)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/TimeXt/TimeXt-Kotlin.svg)](https://jitpack.io/#TimeXt/TimeXt-Kotlin)

[![Version](https://img.shields.io/badge/version-0.7.0-blue.svg)](https://github.com/TimeXt/TimeXt-Kotlin/releases/tag/0.7.0)
[![Build](https://img.shields.io/badge/build-success-green.svg)](timext)
[![CodeCoverage](https://img.shields.io/badge/codeCoverage-71-yellow.svg)](timext)

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Paypal](https://img.shields.io/badge/paypal-donate-blue.svg)](https://www.paypal.me/GuepardoApps)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

First of all many thanks to [Kizitonwose](https://github.com/kizitonwose/Time) for the original idea and already awesome library!

This library shall help to reduce code like...

```kotlin
val dayInMillis = 24 * 60 * 60 * 1000       // Represent a day in millis

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
val fiveCenturies = 5.centuries
val tenDecades = 10.decades
val threeYears = 3.years
val oneWeek = 1.weeks
val threeDays = 3.days
val elevenHours = 11.hours
val sixMinutes = 6.minutes
val fiftySeconds = 50.seconds
val hundredMillis = 100.millis

val oneDayInMillis = 1.days.inMillis        // Returns one day in millis
val twoWeeksInHours = 2.weeks.inHours       // Returns two weeks in hours

// Converts the existing 3h-Class into a 180min-Class
val threeHoursToMinutes = 3.hours.toMinutes() 
// 3.hours === TimeXt(3, TimeXtUnit.hour)
// 180.minutes === TimeXt(180, TimeXtUnit.minute)

val duration = 1.days + 11.hours + 35.minutes + 15.seconds - 250.millis
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

- Version 0.5.0 TimeXt has new extensions for the long type to display this number value in a human readable string format.
- Version 0.6.0 TimeXt supports double and integer numbers. 
- Version 0.6.1 TimeXt adds the method formatWeeks.

```kotlin
val readableStringFromMilliseconds = 34325055574.formatMillis // 56 weeks, 5 days, 6 hours, 44 minutes, 15 seconds, 574 milliseconds
val readableStringFromSeconds = 4350554L.formatSeconds // 7 weeks, 1 day, 8 hours, 29 minutes, 14 seconds
val readableStringFromMinutes = 432555L.formatMinutes // 42 weeks, 6 days, 9 hours, 15 minutes
val readableStringFromHours = 24.formatHours // 21 day
val readableStringFromDays = 7.5.formatDays // 1 week, 12 hours
val readableStringFromWeeks = 2.5.formatWeeks // 2 weeks, 3 days, 12 hours
```

### Custom TimeXtUnit

If you would like to have your own timext unit, implement it as followed:

```kotlin
val microsecond: Double = 1e-3

// Add also some extensions:
val Number.microseconds: TimeXt
    get() = TimeXt(this.toDouble(), microsecond)

val TimeXt.inMicroseconds: TimeXt
    get() = this.value * this.unit / microsecond

fun toMicroseconds(): TimeXt {
    return TimeXt(this.inMicroseconds, microsecond)
}

// Use it like:
val threeMicroseconds = TimeXt(3, microsecond)
val oneMicroseconds = 1.microseconds
val secondInMicroseconds = 1.seconds.inMicroseconds
val microsecondsFromMinutes = 1.minutes.toMicroseconds()

```

## Installation

Add the JitPack repository to your `build.gradle`:

```groovy
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```

Add the dependency to your `build.gradle`:

- For **non-Android** projects:

```groovy
dependencies {
    implementation 'com.github.TimeXt.TimeXt-Kotlin:timext:0.7.0'
}
```

- For **Android** projects:

```groovy
dependencies {
    implementation 'com.github.TimeXt.TimeXt-Kotlin:timext:0.7.0'
    implementation 'com.github.TimeXt.TimeXt-Kotlin:timext-android:0.7.0'
}
```

## Requirements

- Use at least JVM 1.8

## Contributors

| [<img alt="GuepardoApps" src="https://avatars0.githubusercontent.com/u/21952813?v=4&s=117" width="117"/>](https://github.com/GuepardoApps) |
| :---------------------------------------------------------------------------------------------------------------------------------------: |
| [GuepardoApps](https://github.com/GuepardoApps) |

## License

TimeXt-Kotlin is distributed under the MIT license. [See LICENSE](LICENSE.md) for details.

```
MIT License

Copyright (c) 2018 - 2019 GuepardoApps (Jonas Schubert)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
