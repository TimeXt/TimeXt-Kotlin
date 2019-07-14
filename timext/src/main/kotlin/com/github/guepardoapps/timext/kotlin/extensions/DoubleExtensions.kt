package com.github.guepardoapps.timext.kotlin.extensions

import kotlin.math.floor

private val map: Map<String, Pair<Double, Int>> = mapOf(
        "week" to Pair(7 * 24 * 60 * 60 * 1000.0, Int.MAX_VALUE),
        "day" to Pair(24 * 60 * 60 * 1000.0, 7),
        "hour" to Pair(60 * 60 * 1000.0, 24),
        "minute" to Pair(60 * 1000.0, 60),
        "second" to Pair(1000.0, 60),
        "millisecond" to Pair(1.0, 1000)
)

private fun format(value: Double, divider: Double): List<String> {
    return map
            .mapValues { Pair((it.value.first / divider), it.value.second) }
            .map { item ->
                if (((value / item.value.first) % item.value.second) > 0) "${String.format("%.0f", floor(((value / item.value.first) % item.value.second)))} ${item.key}${if (floor((value / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
            }
            .filter { x -> x.isNotEmpty() && !x.startsWith("0") }
}

val Double.formatMillis: String
    get() {
        val stringArray = format(this, 1.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else "0 millisecond"
    }

val Double.formatSeconds: String
    get() {
        val stringArray = format(this, 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 1000).formatMillis
    }

val Double.formatMinutes: String
    get() {
        val stringArray = format(this, 60 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatSeconds
    }

val Double.formatHours: String
    get() {
        val stringArray = format(this, 60 * 60 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatMinutes
    }

val Double.formatDays: String
    get() {
        val stringArray = format(this, 24 * 60 * 60 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatHours
    }