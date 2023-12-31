package com.furkan.data_sources

import android.content.Context
import com.furkan.core.di.DispatcherModule
import com.furkan.model.transportation.TransportationModel
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.utils.Const
import com.furkan.utils.readDataFromAssets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
            gson.fromJson(
                readDataFromAssets(context, Const.JsonFile.transportationJson),
                object : TypeToken<TransportationModel>() {}.type
            )
        }
    }

    suspend fun getTransportationDetailList(): TransportationDetail {
        return withContext(ioDispatcher) {
            gson.fromJson(
                readDataFromAssets(context, Const.JsonFile.transportationDetailJson),
                object : TypeToken<TransportationDetail>() {}.type
            )
        }
    }
}