package br.com.rodrigo.contactapp.extensions

import br.com.rodrigo.contactapp.util.DATE_FORMAT_DISPLAY
import java.text.SimpleDateFormat
import java.util.*

fun Date.convertToString(): String {
    return SimpleDateFormat(
        DATE_FORMAT_DISPLAY,
        Locale.getDefault()
    ).format(this)
}