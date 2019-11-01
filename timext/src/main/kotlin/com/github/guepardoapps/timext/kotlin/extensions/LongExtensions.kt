package com.github.guepardoapps.timext.kotlin.extensions

import kotlin.math.floor

private val map: Map<String, Pair<Long, Int>> = mapOf(
        "week" to Pair(604800 * 1000L, Int.MAX_VALUE),
        "day" to Pair(86400 * 1000L, 7),
        "hour" to Pair(3600 * 1000L, 24),
        "minute" to Pair(60 * 1000L, 60),
        "second" to Pair(1000L, 60),
        "millisecond" to Pair(1L, 1000)
)

private fun format(value: Long, divider: Double): List<String> {
    return map
            .mapValues { Pair((it.value.first / divider), it.value.second) }
            .map { item ->
                if (((value / item.value.first) % item.value.second) > 0) "${String.format("%.0f", floor((value / item.value.first) % item.value.second))} ${item.key}${if (floor((value / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
            }
            .filter { x -> x.isNotEmpty() && !x.startsWith("0") }
}

val Long.formatMillis: String
    get() {
        val stringArray = format(this, 1.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else "0 millisecond"
    }

val Long.formatSeconds: String
    get() {
        val stringArray = format(this, 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 1000).formatMillis
    }

val Long.formatMinutes: String
    get() {
        val stringArray = format(this, 60 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatSeconds
    }

val Long.formatHours: String
    get() {
        val stringArray = format(this, 3600 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatMinutes
    }

val Long.formatDays: String
    get() {
        val stringArray = format(this, 86400 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 24).formatHours
    }

val Long.formatWeeks: String
    get() {
        val stringArray = format(this, 604800 * 1000.0)
        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 7).formatDays
    }