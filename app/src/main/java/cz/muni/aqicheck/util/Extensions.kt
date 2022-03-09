package cz.muni.aqicheck.util

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Long.getNowFormattedDateString(): String {
    val df = SimpleDateFormat("dd.mm.YYYY")
    val date = Date(this)
    return df.format(date)
}