package com.github.guepardoapps.timext.kotlin

import com.github.guepardoapps.timext.kotlin.extensions.*
import org.junit.Assert.*
import org.junit.Test

class TimeXtTests {

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

        assertEquals(10.seconds, 10000.milliseconds)
        assertTrue(20.seconds > 19999.milliseconds)
        assertTrue(30.seconds < 30001.milliseconds)
        assertNotEquals(10.seconds, 10010.milliseconds)
    }

    @Test
    fun `All conversions should work as expected`() {
        assertTrue(4.weeks.inDays == 28.0)
        assertTrue(7.days.inWeeks == 1.0)
        assertTrue(2.5.days.inHours == 60.0)
        assertTrue(5.25.hours.inMinutes == 315.0)
        assertTrue(72.hours.inDays == 3.0)
        assertTrue(360.minutes.inHours == 6.0)
        assertTrue(15.5.minutes.inSeconds == 930.0)
        assertTrue(7200.seconds.inHours == 2.0)
        assertTrue(10800.seconds.inDays == 0.125)
        assertTrue(5.75.seconds.inMilliseconds == 5750.0)
    }

    @Test
    fun `All casts should work as expected`() {
        assertTrue(4.weeks.toDays() == 28.days)
        assertTrue(7.days.toWeeks() == 1.weeks)
        assertTrue(2.5.days.toHours() == 60.hours)
        assertTrue(5.25.hours.toMinutes() == 315.minutes)
        assertTrue(72.hours.toDays() == 3.days)
        assertTrue(360.minutes.toHours() == 6.hours)
        assertTrue(15.5.minutes.toSeconds() == 930.seconds)
        assertTrue(7200.seconds.toHours() == 2.hours)
        assertTrue(10800.seconds.toDays() == 0.125.days)
        assertTrue(5.75.seconds.toMilliseconds() == 5750.milliseconds)
    }

    @Test
    fun `Plus operator should work as expected`() {
        assertTrue((2.weeks + 7.days) == 3.weeks)
        assertTrue((2.5.days + 12.hours) == 3.days)
        assertTrue((2.25.hours + 45.minutes) == 3.hours)
        assertTrue((2.25.minutes + 45.seconds) == 3.minutes)
        assertTrue((2.25.seconds + 750.milliseconds) == 3.seconds)
    }

    @Test
    fun `Minus operator should work as expected`() {
        assertTrue((2.weeks - 7.days) == 1.weeks)
        assertTrue((2.5.days - 12.hours) == 2.days)
        assertTrue((2.25.hours - 15.minutes) == 2.hours)
        assertTrue((2.25.minutes - 15.seconds) == 2.minutes)
        assertTrue((2.25.seconds - 250.milliseconds) == 2.seconds)
    }

    @Test
    fun `Multiplication operator should work as expected`() {
        assertTrue((2.weeks * 2) == 4.weeks)
        assertTrue((2.5.days * 3) == 7.5.days)
        assertTrue((2.25.hours * 4) == 9.hours)
        assertTrue((2.25.minutes * 4) == 9.minutes)
        assertTrue((2.25.seconds * 4) == 9.seconds)
        assertTrue((200.milliseconds * 5) == 1000.milliseconds)
    }

    @Test
    fun `Division operator should work as expected`() {
        assertTrue((2.weeks / 2) == 1.weeks)
        assertTrue((1.5.days / 3) == 0.5.days)
        assertTrue((4.hours / 4) == 1.hours)
        assertTrue((4.minutes / 4) == 1.minutes)
        assertTrue((4.seconds / 4) == 1.seconds)
        assertTrue((200.milliseconds / 5) == 40.milliseconds)
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

        var actualMilliseconds = 100.milliseconds
        assertTrue(++actualMilliseconds == 101.milliseconds)
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

        var actualMilliseconds = 100.milliseconds
        assertTrue(--actualMilliseconds == 99.milliseconds)
    }

    @Test
    fun `CompareTo operator should work as expected`() {
        assertTrue(55.milliseconds.compareTo(60.milliseconds) == -1)
    }

    @Test
    fun `Contains & in operator should work as expected`() {
        assertTrue((60.milliseconds.contains(55.milliseconds)))
        assertFalse((55.milliseconds.contains(60.milliseconds)))
        assertTrue(55.milliseconds in 60.milliseconds)
        assertFalse(60.milliseconds in 55.milliseconds)
    }

    @Test
    fun `HashCode should work as expected`() {
        assertEquals(1078689792, 55.milliseconds.hashCode())
    }
}
