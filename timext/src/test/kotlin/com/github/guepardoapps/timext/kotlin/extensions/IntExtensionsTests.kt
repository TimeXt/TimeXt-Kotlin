package com.github.guepardoapps.timext.kotlin.extensions

import org.junit.Assert.*
import org.junit.Test

class IntExtensionsTests {

    @Test
    fun `formatMilliseconds should work as expected`() {
        // Arrange
        val expected = "3 seconds, 650 milliseconds"

        // Act
        val actual = 3650.formatMillis

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatSeconds should work as expected`() {
        // Arrange
        val expected = "16 minutes, 15 seconds"

        // Act
        val actual = 975.formatSeconds

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatMinutes should work as expected`() {
        // Arrange
        val expected = "7 hours, 24 minutes"

        // Act
        val actual = 444.formatMinutes

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatHours should work as expected`() {
        // Arrange
        val expected = "2 days, 12 hours"

        // Act
        val actual = 60.formatHours

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatDays should work as expected`() {
        // Arrange
        val expected = "2 weeks, 4 days"

        // Act
        val actual = 18.formatDays

        // Assert
        assertEquals(expected, actual)
    }

    @Test
    fun `formatWeeks should work as expected`() {
        // Arrange
        val expected = "2 weeks"

        // Act
        val actual = 2.formatWeeks

        // Assert
        assertEquals(expected, actual)
    }
}
