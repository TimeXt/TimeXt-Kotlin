package com.github.guepardoapps.timext.kotlin.extensions

import org.junit.Assert.*
import org.junit.Test

class LongExtensionsTests {

    @Test
    fun `formatMilliseconds should work as expected`() {
        // Arrange
        val expected = "56 weeks, 5 days, 6 hours, 44 minutes, 15 seconds, 574 milliseconds"

        // Act
        val actual = 34325055574.formatMilliseconds

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatSeconds should work as expected`() {
        // Arrange
        val expected = "7 weeks, 1 day, 8 hours, 29 minutes, 14 seconds"

        // Act
        val actual = 4350554L.formatSeconds

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatMinutes should work as expected`() {
        // Arrange
        val expected = "42 weeks, 6 days, 9 hours, 15 minutes"

        // Act
        val actual = 432555L.formatMinutes

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatHours should work as expected`() {
        // Arrange
        val expected = "27 weeks, 1 day, 14 hours"

        // Act
        val actual = 4574L.formatHours

        // Assert
        assertEquals(expected, actual)
    }
}
