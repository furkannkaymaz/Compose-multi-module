package com.furkan.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataConverter {

    companion object{

        val gSon: Gson by lazy { GsonBuilder().disableHtmlEscaping().create() }

        inline fun <reified T> fromJson(json:String?):T = gSon.fromJson(json, typeToken<T>())

        inline fun <reified T> toJson(data:T):String = gSon.toJson(data, typeToken<T>())

        inline fun <reified T> typeToken(): Type = object : TypeToken<T>() {}.type
    }
}