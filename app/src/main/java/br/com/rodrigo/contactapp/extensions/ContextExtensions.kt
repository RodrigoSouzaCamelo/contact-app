package br.com.rodrigo.contactapp.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun Context.showMessage(
    text: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        this,
        text,
        duration
    ).show()
}

fun Context.callPhone(phoneNumber: String) {
    val uri = Uri.parse("tel:$phoneNumber")

    // Create the intent and set the data for the
    // intent as the phone number.
    val intent = Intent(Intent.ACTION_DIAL, uri)
    try {

        // Launch the Phone app's dialer with a phone
        // number to dial a call.
        startActivity(intent)
    } catch (e: SecurityException) {

        // show() method display the toast with
        // exception message.
        showMessage("An error occurred")
    }
}

fun Context.sendSMS(phoneNumber: String) {
    val uri = Uri.parse("sms:$phoneNumber")

    // Create the intent and set the data for the
    // intent as the phone number.
    val intent = Intent(Intent.ACTION_VIEW, uri)
    try {

        // Launch the Phone app's dialer with a phone
        // number to dial a call.
        startActivity(intent)
    } catch (e: SecurityException) {

        // show() method display the toast with
        // exception message.
        showMessage("An error occurred")
    }
}