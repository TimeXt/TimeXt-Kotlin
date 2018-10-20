package guepardoapps.timext.kotlin

import guepardoapps.timext.kotlin.extensions.*
import org.junit.Assert.*
import org.junit.Test

class DateTimeExtendedTest {

    @Test
    fun `All comparisons should work as expected`() {
        assertEquals(2.weeks, 14.days)
        assertTrue(3.weeks > 20.days)
        assertTrue(4.weeks < 29.days)
        assertNotEquals(2.weeks, 13.days)

        assertEquals(2.days, 48.hours)
        assertTrue(1.days > 23.hours)
        assertTrue(0.days < 1.hours)
        assertNotEquals(2.days, 49.hours)

        assertEquals(2.hours, 120.minutes)
        assertTrue(3.hours > 179.minutes)
        assertTrue(5.hours < 301.minutes)
        assertNotEquals(2.hours, 121.minutes)

        assertEquals(15.minutes, 900.seconds)
        assertTrue(30.minutes > 1799.seconds)
        assertTrue(45.minutes < 2701.seconds)
        assertNotEquals(15.minutes, 899.seconds)

        assertEquals(10.seconds, 10000.milliSeconds)
        assertTrue(20.seconds > 19999.milliSeconds)
        assertTrue(30.seconds < 30001.milliSeconds)
        assertNotEquals(10.seconds, 10010.milliSeconds)

        assertEquals(10.milliSeconds, 10000.microSeconds)
        assertTrue(20.milliSeconds > 19999.microSeconds)
        assertTrue(30.milliSeconds < 30001.microSeconds)
        assertNotEquals(10.milliSeconds, 10010.microSeconds)

        assertEquals(10.microSeconds, 10000.nanoSeconds)
        assertTrue(20.microSeconds > 19999.nanoSeconds)
        assertTrue(30.microSeconds < 30001.nanoSeconds)
        assertNotEquals(10.microSeconds, 10010.nanoSeconds)

        assertEquals(10.nanoSeconds, 10000.picoSeconds)
        assertTrue(20.nanoSeconds > 19999.picoSeconds)
        assertTrue(30.nanoSeconds < 30001.picoSeconds)
        assertNotEquals(10.nanoSeconds, 10010.picoSeconds)
    }

    @Test
    fun `All conversions should work as expected`() {
        assertTrue(4.weeks.inDays.value == 28.0)
        assertTrue(7.days.inWeeks.value == 1.0)
        assertTrue(2.5.days.inHours.value == 60.0)
        assertTrue(5.25.hours.inMinutes.value == 315.0)
        assertTrue(72.hours.inDays.value == 3.0)
        assertTrue(360.minutes.inHours.value == 6.0)
        assertTrue(15.5.minutes.inSeconds.value == 930.0)
        assertTrue(7200.seconds.inHours.value == 2.0)
        assertTrue(10800.seconds.inDays.value == 0.125)
        assertTrue(5.75.seconds.inMilliSeconds.value == 5750.0)
        assertTrue(5.75.milliSeconds.inMicroSeconds.value == 5750.0)
        assertTrue(5.75.microSeconds.inNanoSeconds.value == 5750.0)
        assertTrue(5.75.nanoSeconds.inPicoSeconds.value == 5750.0)
    }

    @Test
    fun `Plus operator should work as expected`() {
        assertTrue((2.weeks + 7.days) == 3.weeks)
        assertTrue((2.5.days + 12.hours) == 3.days)
        assertTrue((2.25.hours + 45.minutes) == 3.hours)
        assertTrue((2.25.minutes + 45.seconds) == 3.minutes)
        assertTrue((2.25.seconds + 750.milliSeconds) == 3.seconds)
        assertTrue((225.225.milliSeconds + 775.microSeconds) == 226.milliSeconds)
        assertTrue((225.225.microSeconds + 775.nanoSeconds) == 226.microSeconds)
        assertTrue((225.225.nanoSeconds + 775.picoSeconds) == 226.nanoSeconds)
    }

    @Test
    fun `Minus operator should work as expected`() {
        assertTrue((2.weeks - 7.days) == 1.weeks)
        assertTrue((2.5.days - 12.hours) == 2.days)
        assertTrue((2.25.hours - 15.minutes) == 2.hours)
        assertTrue((2.25.minutes - 15.seconds) == 2.minutes)
        assertTrue((2.25.seconds - 250.milliSeconds) == 2.seconds)
        assertTrue((225.225.milliSeconds - 225.microSeconds) == 225.milliSeconds)
        assertTrue((225.225.microSeconds - 225.nanoSeconds) == 225.microSeconds)
        assertTrue((225.225.nanoSeconds - 225.picoSeconds) == 225.nanoSeconds)
    }

    @Test
    fun `Multiplication operator should work as expected`() {
        assertTrue((2.weeks * 2) == 4.weeks)
        assertTrue((2.5.days * 3) == 7.5.days)
        assertTrue((2.25.hours * 4) == 10.hours)
        assertTrue((2.25.minutes * 4) == 10.minutes)
        assertTrue((2.25.seconds * 4) == 10.seconds)
        assertTrue((200.milliSeconds * 5) == 1000.milliSeconds)
        assertTrue((200.microSeconds * 5) == 1000.microSeconds)
        assertTrue((200.nanoSeconds * 5) == 1000.nanoSeconds)
    }

    @Test
    fun `Division operator should work as expected`() {
        assertTrue((2.weeks / 2) == 1.weeks)
        assertTrue((1.5.days / 3) == 0.5.days)
        assertTrue((4.hours / 4) == 1.hours)
        assertTrue((4.minutes / 4) == 1.minutes)
        assertTrue((4.seconds / 4) == 1.seconds)
        assertTrue((200.milliSeconds / 5) == 40.milliSeconds)
        assertTrue((200.microSeconds / 5) == 40.microSeconds)
        assertTrue((200.nanoSeconds / 5) == 40.nanoSeconds)
    }

    @Test
    fun `Increment operator should work as expected`() {
        var actualWeeks = 2.weeks
        assertTrue(++actualWeeks == 3.weeks)

        var actualDays = 3.days
        assertTrue(++actualDays == 4.days)

        var actualHours = 4.hours
        assertTrue(++actualHours == 5.hours)

        var actualMinutes = 5.minutes
        assertTrue(++actualMinutes == 6.minutes)

        var actualSeconds = 6.seconds
        assertTrue(++actualSeconds == 7.seconds)

        var actualMilliSeconds = 100.milliSeconds
        assertTrue(++actualMilliSeconds == 101.milliSeconds)

        var actualMicroSeconds = 100.microSeconds
        assertTrue(++actualMicroSeconds == 101.microSeconds)

        var actualNanoSeconds = 100.nanoSeconds
        assertTrue(++actualNanoSeconds == 101.nanoSeconds)

        var actualPicoSeconds = 100.picoSeconds
        assertTrue(++actualPicoSeconds == 101.picoSeconds)
    }

    @Test
    fun `Decrement operator should work as expected`() {
        var actualWeeks = 2.weeks
        assertTrue(--actualWeeks == 1.weeks)

        var actualDays = 3.days
        assertTrue(--actualDays == 2.days)

        var actualHours = 4.hours
        assertTrue(--actualHours == 3.hours)

        var actualMinutes = 5.minutes
        assertTrue(--actualMinutes == 4.minutes)

        var actualSeconds = 6.seconds
        assertTrue(--actualSeconds == 5.seconds)

        var actualMilliSeconds = 100.milliSeconds
        assertTrue(--actualMilliSeconds == 99.milliSeconds)

        var actualMicroSeconds = 100.microSeconds
        assertTrue(--actualMicroSeconds == 99.microSeconds)

        var actualNanoSeconds = 100.nanoSeconds
        assertTrue(--actualNanoSeconds == 99.nanoSeconds)

        var actualPicoSeconds = 100.picoSeconds
        assertTrue(--actualPicoSeconds == 99.picoSeconds)
    }

    @Test
    fun `CompareTo operator should work as expected`() {
        assertTrue((55.nanoSeconds.compareTo(60.nanoSeconds)) == 5)
    }

    @Test
    fun `Contains & in operator should work as expected`() {
        assertTrue((60.nanoSeconds.contains(55.nanoSeconds)))
        assertFalse((55.nanoSeconds.contains(60.nanoSeconds)))
        assertTrue(55.nanoSeconds in 60.nanoSeconds)
        assertFalse(60.nanoSeconds in 55.nanoSeconds)
    }
}
