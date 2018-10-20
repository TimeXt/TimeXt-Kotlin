package guepardoapps.timext.kotlin

interface IDateTimeUnit {
    val dateTimeIntervalRatio: Double

    fun <ConversionUnit : IDateTimeUnit> conversionRate(conversionUnit: ConversionUnit): Double {
        return dateTimeIntervalRatio / conversionUnit.dateTimeIntervalRatio
    }
}
