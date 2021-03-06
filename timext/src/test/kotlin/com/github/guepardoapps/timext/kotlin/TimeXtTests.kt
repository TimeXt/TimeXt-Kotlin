package com.github.guepardoapps.timext.kotlin

import com.github.guepardoapps.timext.kotlin.extensions.*
import org.junit.Assert.*
import org.junit.Test

class TimeXtTests {

    @Test
    fun `All comparisons should work as expected`() {
        assertEquals(2.centuries, 20.decades)
        assertTrue(3.centuries > 20.decades)
        assertTrue(0.5.centuries < 6.decades)
        assertNotEquals(2.centuries, 20.1.decades)

        assertEquals(2.decades, 20.years)
        assertTrue(3.decades > 20.years)
        assertTrue(0.5.decades < 6.years)
        assertNotEquals(2.decades, 20.1.years)

        assertEquals(2.years, 730.5.days)
        assertTrue(3.years > 20.days)
        assertTrue(0.5.years < 200.days)
        assertNotEquals(2.years, 730.0.days)

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

        assertEquals(10.seconds, 10000.millis)
        assertTrue(20.seconds > 19999.millis)
        assertTrue(30.seconds < 30001.millis)
        assertNotEquals(10.seconds, 10010.millis)
    }

    @Test
    fun `All conversions should work as expected`() {
        assertTrue(1.centuries.inDecades == 10.0)
        assertTrue(1.decades.inYears == 10.0)
        assertTrue(1.years.inDays == 365.25)
        assertTrue(4.weeks.inDays == 28.0)
        assertTrue(7.days.inWeeks == 1.0)
        assertTrue(2.5.days.inHours == 60.0)
        assertTrue(5.25.hours.inMinutes == 315.0)
        assertTrue(72.hours.inDays == 3.0)
        assertTrue(360.minutes.inHours == 6.0)
        assertTrue(15.5.minutes.inSeconds == 930.0)
        assertTrue(7200.seconds.inHours == 2.0)
        assertTrue(10800.seconds.inDays == 0.125)
        assertTrue(5.75.seconds.inMillis == 5750.0)
    }

    @Test
    fun `All casts should work as expected`() {
        assertTrue(2.centuries.toDecades() == 20.decades)
        assertTrue(2.decades.toYears() == 20.years)
        assertTrue(2.years.toDays() == 730.5.days)
        assertTrue(4.weeks.toDays() == 28.days)
        assertTrue(7.days.toWeeks() == 1.weeks)
        assertTrue(2.5.days.toHours() == 60.hours)
        assertTrue(5.25.hours.toMinutes() == 315.minutes)
        assertTrue(72.hours.toDays() == 3.days)
        assertTrue(360.minutes.toHours() == 6.hours)
        assertTrue(15.5.minutes.toSeconds() == 930.seconds)
        assertTrue(7200.seconds.toHours() == 2.hours)
        assertTrue(10800.seconds.toDays() == 0.125.days)
        assertTrue(5.75.seconds.toMillis() == 5750.millis)
    }

    @Test
    fun `Plus operator should work as expected`() {
        assertTrue((1.years + 365.25.days) == 2.years)
        assertTrue((2.weeks + 7.days) == 3.weeks)
        assertTrue((2.5.days + 12.hours) == 3.days)
        assertTrue((2.25.hours + 45.minutes) == 3.hours)
        assertTrue((2.25.minutes + 45.seconds) == 3.minutes)
        assertTrue((2.25.seconds + 750.millis) == 3.seconds)
    }

    @Test
    fun `Minus operator should work as expected`() {
        assertTrue((2.years - 365.25.days) == 1.years)
        assertTrue((2.weeks - 7.days) == 1.weeks)
        assertTrue((2.5.days - 12.hours) == 2.days)
        assertTrue((2.25.hours - 15.minutes) == 2.hours)
        assertTrue((2.25.minutes - 15.seconds) == 2.minutes)
        assertTrue((2.25.seconds - 250.millis) == 2.seconds)
    }

    @Test
    fun `Multiplication operator should work as expected`() {
        assertTrue((1.years * 2.5) == 2.5.years)
        assertTrue((2.weeks * 2) == 4.weeks)
        assertTrue((2.5.days * 3) == 7.5.days)
        assertTrue((2.25.hours * 4) == 9.hours)
        assertTrue((2.25.minutes * 4) == 9.minutes)
        assertTrue((2.25.seconds * 4) == 9.seconds)
        assertTrue((200.millis * 5) == 1000.millis)
    }

    @Test
    fun `Division operator should work as expected`() {
        assertTrue((1.years / 5) == 0.2.years)
        assertTrue((2.weeks / 2) == 1.weeks)
        assertTrue((1.5.days / 3) == 0.5.days)
        assertTrue((4.hours / 4) == 1.hours)
        assertTrue((4.minutes / 4) == 1.minutes)
        assertTrue((4.seconds / 4) == 1.seconds)
        assertTrue((200.millis / 5) == 40.millis)
    }

    @Test
    fun `Increment operator should work as expected`() {
        var actualYears = 2.years
        assertTrue(++actualYears == 3.years)

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

        var actualMilliseconds = 100.millis
        assertTrue(++actualMilliseconds == 101.millis)
    }

    @Test
    fun `Decrement operator should work as expected`() {
        var actualYears = 2.years
        assertTrue(--actualYears == 1.years)

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

        var actualMilliseconds = 100.millis
        assertTrue(--actualMilliseconds == 99.millis)
    }

    @Test
    fun `CompareTo operator should work as expected`() {
        assertTrue(55.millis.compareTo(60.millis) == -1)
    }

    @Test
    fun `Contains & in operator should work as expected`() {
        assertTrue((60.millis.contains(55.millis)))
        assertFalse((55.millis.contains(60.millis)))
        assertTrue(55.millis in 60.millis)
        assertFalse(60.millis in 55.millis)
    }

    @Test
    fun `HashCode should work as expected`() {
        assertEquals(1078689792, 55.millis.hashCode())
    }
}
