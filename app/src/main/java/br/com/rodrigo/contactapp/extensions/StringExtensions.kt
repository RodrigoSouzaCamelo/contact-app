package br.com.rodrigo.contactapp.extensions

import br.com.rodrigo.contactapp.util.FORMAT_DATE_DAY_MONTH_YEAR
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.convertToDate(): Date? {
    return try {
        SimpleDateFormat(
            FORMAT_DATE_DAY_MONTH_YEAR,
            Locale.getDefault()
        ).parse(this)
    } catch (e: ParseException) {
        null
    }
}