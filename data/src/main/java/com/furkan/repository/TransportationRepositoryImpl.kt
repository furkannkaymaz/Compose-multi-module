package com.furkan.repository

import android.util.Log
import com.furkan.compose_multi_module.data.R
import com.furkan.core.infrastructure.StringResourceProvider
import com.furkan.core.infrastructure.StringResourceProviderImpl
import com.furkan.data_sources.TransportationLocalDataSources
import com.furkan.data_sources.TransportationRemoteDataSources
import com.furkan.mapper.TransportationDetailMapper
import com.furkan.model.transportation.TransportationModel
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
select and adjust data according to requests and conditions
 */

class TransportationRepositoryImpl @Inject constructor(
    private val remoteDataSources: TransportationRemoteDataSources,
    private val localDataSources: TransportationLocalDataSources,
    private val mapper: TransportationDetailMapper,
    private val stringResourceProviderImpl: StringResourceProvider
) : TransportationRepository {

    override fun getTransportationList() = flow<Resource<TransportationModel>> {
        emit(Resource.Success(remoteDataSources.getTransportationList()))
    }.catch { e ->
        Log.e("TransportationRepository", "Error fetching transportation list from remote")
        try {
            emit(Resource.Success(localDataSources.getTransportationList()))
        } catch (e: Exception) {
            Log.e(
                "TransportationRepository",
                "Error fetching transportation list from remote and local"
            )
            emit(Resource.Error("Error Message"))
        }
    }

    override fun getTransportationDetailList() = flow<Resource<TransportationUiDetail>> {
        emit(Resource.Success(mapper.map(localDataSources.getTransportationDetailList())))
    }.catch {
        emit(Resource.Error(stringResourceProviderImpl.getString((R.string.txt_error_message))))
    }
}