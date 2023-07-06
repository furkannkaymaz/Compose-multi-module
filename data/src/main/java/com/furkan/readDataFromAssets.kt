package com.furkan

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

fun readDataFromAssets(context: Context, fileName: String): String {
    val inputStream = context.assets.open(fileName)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = StringBuilder().apply {
        bufferedReader.forEachLine { append(it) }
    }.toString()
    return jsonString
}
