package com.furkan.data_sources

import android.content.Context
import com.furkan.core.di.DispatcherModule
import com.furkan.model.TransportationModel
import com.furkan.readDataFromAssets
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TransportationLocalDataSources @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
    @DispatcherModule.IODispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getTransportationList(): TransportationModel {
        return withContext(ioDispatcher) {
            val jsonString = readDataFromAssets(context, "transportation.json")
            val transportationData = gson.fromJson(jsonString, TransportationModel::class.java)
            transportationData
        }
    }
}