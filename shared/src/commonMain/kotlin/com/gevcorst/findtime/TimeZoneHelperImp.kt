package com.gevcorst.findtime
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import

class TimeZoneHelperImp:TimeZoneHelper {
    private val currentMoment: Instant = Clock.System.now()
    override fun getTimeZoneStrings(): List<String> {
        TODO("Not yet implemented")
    }

    override fun currentTime(): String {
        //val currentMoment: Instant = Clock.System.now()
        val dateTime:LocalDateTime = currentMoment.toLocalDateTime(
            TimeZone.currentSystemDefault())
        return formatDateTime(dateTime)
    }

    override fun currentTimeZone(): String {
        TODO("Not yet implemented")
    }

    override fun hoursFromTimeZone(otherTimeZoneId: String): Double {
        TODO("Not yet implemented")
    }

    override fun getTime(timezoneId: String): String {
        val timezone = TimeZone.of(timezoneId)
        val dateTime:LocalDateTime = currentMoment.toLocalDateTime(timezone)
        return formatDateTime(dateTime)

    }

    override fun getDate(timezoneId: String): String {
        TODO("Not yet implemented")
    }

    override fun search(startHour: Int, endHour: Int, timezoneStrings: List<String>): List<Int> {
        TODO("Not yet implemented")
    }
}
fun formatDateTime(dateTime: LocalDateTime): String {
    val stringBuilder = StringBuilder()
    val minute = dateTime.minute
    var hour = dateTime.hour % 12
    if (hour == 0) hour = 12
    val amPm = if (dateTime.hour < 12) " am" else " pm"
    stringBuilder.append(hour.toString())
    stringBuilder.append(":")
    if (minute < 10) {
        stringBuilder.append('0')
    }
    stringBuilder.append(minute.toString())
    stringBuilder.append(amPm)
    return stringBuilder.toString()
}