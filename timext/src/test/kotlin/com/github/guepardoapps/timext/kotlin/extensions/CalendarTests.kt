package com.github.guepardoapps.timext.kotlin.extensions

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class CalendarTests {

    @Test
    fun `Plus TimeXt operator should work as expected`() {
        val calendar = Calendar.getInstance()
        calendar.set(2018, 10, 28, 11, 18, 0)

        val expected = Calendar.getInstance()
        expected.set(2018, 10, 28, 12, 18, 0)

        val actual = calendar + 1.hours

        assertEquals(expected.timeInMillis, actual.timeInMillis)
    }

    @Test
    fun `Minus TimeXt operator should work as expected`() {
        val calendar = Calendar.getInstance()
        calendar.set(2018, 10, 28)

        val expected = Calendar.getInstance()
        expected.set(2018, 10, 14)

        val actual = calendar - 2.weeks

        assertEquals(expected.timeInMillis.toDouble(), actual.timeInMillis.toDouble(), 2.0)
    }

    @Test
    fun `Minus Calendar operator should work as expected`() {
        val calendar1 = Calendar.getInstance()
        calendar1.set(2018, 10, 28)

        val calendar2 = Calendar.getInstance()
        calendar2.set(2018, 10, 21)

        val actual = calendar1 - calendar2

        assertEquals(1.weeks.inMillis, actual.value, 1.0)
    }
}
