package com.furkan.utils.conventer

fun Any?.toJson(): String = DataConverter.toJson(this)

inline fun <reified T> String?.toObject(): T = DataConverter.fromJson(this)

inline fun <reified T> Map<String, Any>.toObject(): T = convert()

inline fun <reified T> T.toMap(): Map<String, Any> = convert()

inline fun <reified T, reified R> T.convert(): R = DataConverter.toJson(this).toObject()
