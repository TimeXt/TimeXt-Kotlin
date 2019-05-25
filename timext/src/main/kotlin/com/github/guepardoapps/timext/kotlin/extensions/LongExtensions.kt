package com.github.guepardoapps.timext.kotlin.extensions

val Long.formatMilliseconds: String
    get() {
        val map: Map<String, Pair<Long, Int>> = mapOf(
                "week" to Pair(7 * 24 * 60 * 60 * 1000L, Int.MAX_VALUE),
                "day" to Pair(24 * 60 * 60 * 1000L, 7),
                "hour" to Pair(60 * 60 * 1000L, 24),
                "minute" to Pair(60 * 1000L, 60),
                "second" to Pair(1000L, 60),
                "millisecond" to Pair(1L, 1000)
        )

        val stringArray = map
                .map { item ->
                    if (((this / item.value.first) % item.value.second) > 0) "${((this / item.value.first) % item.value.second)} ${item.key}${if (((this / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
                }
                .filter { x -> x.isNotEmpty() }

        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else "0 millisecond"
    }

val Long.formatSeconds: String
    get() {
        val map: Map<String, Pair<Long, Int>> = mapOf(
                "week" to Pair(7 * 24 * 60 * 60 * 1L, Int.MAX_VALUE),
                "day" to Pair(24 * 60 * 60 * 1L, 7),
                "hour" to Pair(60 * 60 * 1L, 24),
                "minute" to Pair(60 * 1L, 60),
                "second" to Pair(1L, 60)
        )

        val stringArray = map
                .map { item ->
                    if (((this / item.value.first) % item.value.second) > 0) "${((this / item.value.first) % item.value.second)} ${item.key}${if (((this / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
                }
                .filter { x -> x.isNotEmpty() }

        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 1000).formatMilliseconds
    }

val Long.formatMinutes: String
    get() {
        val map: Map<String, Pair<Long, Int>> = mapOf(
                "week" to Pair(7 * 24 * 60 * 1L, Int.MAX_VALUE),
                "day" to Pair(24 * 60 * 1L, 7),
                "hour" to Pair(60 * 1L, 24),
                "minute" to Pair(1L, 60)
        )

        val stringArray = map
                .map { item ->
                    if (((this / item.value.first) % item.value.second) > 0) "${((this / item.value.first) % item.value.second)} ${item.key}${if (((this / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
                }
                .filter { x -> x.isNotEmpty() }

        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatSeconds
    }

val Long.formatHours: String
    get() {
        val map: Map<String, Pair<Long, Int>> = mapOf(
                "week" to Pair(7 * 24 * 1L, Int.MAX_VALUE),
                "day" to Pair(24 * 1L, 7),
                "hour" to Pair(1L, 24)
        )

        val stringArray = map
                .map { item ->
                    if (((this / item.value.first) % item.value.second) > 0) "${((this / item.value.first) % item.value.second)} ${item.key}${if (((this / item.value.first) % item.value.second) > 1) "s" else ""}" else ""
                }
                .filter { x -> x.isNotEmpty() }

        return if (stringArray.isNotEmpty()) stringArray.joinToString(", ") else (this * 60).formatMinutes
    }