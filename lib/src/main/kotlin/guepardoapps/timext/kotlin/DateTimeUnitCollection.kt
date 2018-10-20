package guepardoapps.timext.kotlin

class Week : IDateTimeUnit {
    override val dateTimeIntervalRatio = 7 * 24.0 * 60.0 * 60.0
}

class Day : IDateTimeUnit {
    override val dateTimeIntervalRatio = 24.0 * 60.0 * 60.0
}

class Hour : IDateTimeUnit {
    override val dateTimeIntervalRatio = 60.0 * 60.0
}

class Minute : IDateTimeUnit {
    override val dateTimeIntervalRatio = 60.0
}

class Second : IDateTimeUnit {
    override val dateTimeIntervalRatio = 1e-0
}

class MilliSecond : IDateTimeUnit {
    override val dateTimeIntervalRatio = 1e-3
}

class MicroSecond : IDateTimeUnit {
    override val dateTimeIntervalRatio = 1e-6
}

class NanoSecond : IDateTimeUnit {
    override val dateTimeIntervalRatio = 1e-9
}

class PicoSecond : IDateTimeUnit {
    override val dateTimeIntervalRatio = 1e-12
}
