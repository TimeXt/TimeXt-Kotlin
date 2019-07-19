package com.github.guepardoapps.timext.kotlin.extensions

import org.junit.Assert.*
import org.junit.Test

class DoubleExtensionsTests {

    @Test
    fun `formatMilliseconds should work as expected`() {
        // Arrange
        val expected = "3 seconds, 650 milliseconds"

        // Act
        val actual = 3650.0.formatMillis

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatSeconds should work as expected`() {
        // Arrange
        val expected = "2 minutes, 10 seconds, 500 milliseconds"

        // Act
        val actual = 130.5.formatSeconds

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatMinutes should work as expected`() {
        // Arrange
        val expected = "45 seconds"

        // Act
        val actual = 0.75.formatMinutes

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatHours should work as expected`() {
        // Arrange
        val expected = "2 hours, 15 minutes"

        // Act
        val actual = 2.25.formatHours

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatDays should work as expected`() {
        // Arrange
        val expected = "18 hours"

        // Act
        val actual = 0.75.formatDays

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatWeeks should work as expected`() {
        // Arrange
        val expected = "1 week, 3 days, 12 hours"

        // Act
        val actual = 1.5.formatWeeks

        // Assert
        assertEquals(expected, actual)
    }
}
