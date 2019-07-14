package com.github.guepardoapps.timext.kotlin.extensions

import org.junit.Assert.*
import org.junit.Test

class DateTests {

    @Test
    fun `Sql Date Plus TimeXt operator should work as expected`() {
        val date = java.sql.Date(1540719288642)
        val oneHour = 1.hours

        val expected = java.sql.Date(1540722888642)

        val actual = date + oneHour

        assertEquals(expected.time, actual.time)
    }

    @Test
    fun `Sql Date Minus TimeXt operator should work as expected`() {
        val date = java.sql.Date(1540722888642)
        val oneHour = 1.hours

        val expected = java.sql.Date(1540719288642)

        val actual = date - oneHour

        assertEquals(expected.time, actual.time)
    }

    @Test
    fun `Sql Date Minus Sql Date operator should work as expected`() {
        val date1 = java.sql.Date(1540722888642)
        val date2 = java.sql.Date(1540719288642)

        val actual = date1 - date2

        val expected = 1.hours

        assertEquals(expected.inMillis, actual.value, 1.0)
    }

    @Test
    fun `Util Date Plus TimeXt operator should work as expected`() {
        val date = java.util.Date(1540719288642)
        val oneHour = 1.hours

        val expected = java.util.Date(1540722888642)

        val actual = date + oneHour

        assertEquals(expected.time, actual.time)
    }

    @Test
    fun `Util Date Minus TimeXt operator should work as expected`() {
        val date = java.util.Date(1540722888642)
        val oneHour = 1.hours

        val expected = java.util.Date(1540719288642)

        val actual = date - oneHour

        assertEquals(expected.time, actual.time)
    }

    @Test
    fun `Util Date Minus Sql Date operator should work as expected`() {
        val date1 = java.util.Date(1540722888642)
        val date2 = java.util.Date(1540719288642)

        val actual = date1 - date2

        val expected = 1.hours

        assertEquals(expected.inMillis, actual.value, 1.0)
    }
}
