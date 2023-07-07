package com.furkan.utils.extensions

import com.furkan.utils.DataConverter

fun Any?.toJson(): String = DataConverter.toJson(this)

/**
 *  Convert a String to an Object
 */
inline fun <reified T> String?.toObject(): T = DataConverter.fromJson(this)

/**
 * Convert a Map to an Object
 */
inline fun <reified T> Map<String, Any>.toObject(): T = convert()

/**
 * Convert an object to a Map
 */
inline fun <reified T> T.toMap(): Map<String, Any> = convert()

/**
 * Convert an object of type T to type R
 */
inline fun <reified T, reified R> T.convert(): R = DataConverter.toJson(this).toObject()
//inline fun <T, reified R> T.convert(): R =  gSon.toJson(this).toObject()