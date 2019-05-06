package ltc.ru.sharedui.date

import android.content.Context
import ltc.ru.sharedui.R
import java.lang.Long.parseLong
import java.text.SimpleDateFormat
import java.util.*

class ConverterDate {
    private lateinit var mainTime: String
    private lateinit var oldDateConverted: Date
    private lateinit var currentDateConverted: Date
    private lateinit var currentDate: String
    private lateinit var oldDate: String
    private lateinit var nowTimeWord: String
    private var days: Long = 0
    private var hours: Long = 0
    private var minutes: Long = 0
    private var seconds: Long = 0
    private var diff: Long = 0
    private var sdf = SimpleDateFormat("yyyy-M-dd hh:mm:ss")
    private var sdfForOldDate = SimpleDateFormat("yyyy-M-dd hh:mm:ss")


    fun getTimePublication(timeString: String, context: Context): String {
        this.mainTime = timeString
        return getDifferenceDates(context)
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-M-dd hh:mm:s")
        return sdf.format(Date())
    }

    private fun getDifferenceDates(context: Context): String {
        getDates()
        parseDates()
        calculateTime()
        return checkTime(context)
    }

    private fun parseDates() {
        oldDateConverted = Date(parseLong(mainTime + "000"))
        currentDateConverted = sdf.parse(currentDate)

    }

    private fun getDates() {
        currentDate = getCurrentDate()
        oldDate = mainTime
    }

    private fun calculateTime() {
        diff = currentDateConverted.time - oldDateConverted.time

        seconds = diff / 1000
        minutes = seconds / 60
        hours = minutes / 60
        days = hours / 24
    }

    private fun checkTime(context: Context): String {
        nowTimeWord = context.resources.getString(R.string.now_time_word)
        if (days > 0) {
            if (days > 30) {
                return sdfForOldDate.format(Date(parseLong(oldDate))).toString()
            } else {
                return days.toString() + " " + context.resources.getQuantityString(R.plurals.plurals_days, days.toInt())
            }
        } else if (hours > 0) {
            return hours.toString() + " " + context.resources.getQuantityString(R.plurals.plurals_hours, hours.toInt())
        } else if (minutes > 0) {
            return minutes.toString() + " " + context.resources.getQuantityString(
                R.plurals.plurals_minutes,
                minutes.toInt()
            )
        } else if (seconds > 0) {
            return seconds.toString() + " " + context.resources.getQuantityString(
                R.plurals.plurals_second,
                seconds.toInt()
            )
        } else {
            return nowTimeWord
        }
    }


}
