package com.furkan.presentation.detail

import com.furkan.presentation.detail.DetailScreenData.detailItem
import com.furkan.presentation.detail.DetailScreenData.errorText
import com.furkan.presentation.detail.DetailScreenData.id
import com.furkan.uiModel.transportation_detail.TransportationUiDetailItem
import com.furkan.usecase.GetTransportationDetailUseCase
import io.mockk.clearAllMocks
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    @Mock
    private lateinit var getTransportationDetailUseCase: GetTransportationDetailUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        detailViewModel = DetailViewModel(getTransportationDetailUseCase)
    }

    @Test
    fun whenGetTransportationDetailUseCaseIsData_DataReturn() = runBlocking {

        var result: TransportationUiDetailItem? = null
        whenever(getTransportationDetailUseCase.invoke(id)).thenReturn(
            listOf(
                GetTransportationDetailUseCase.GetTransportationDetailUseCaseState.Data(
                    detailItem
                )
            ).asFlow()
        )

        detailViewModel.getTransportations(id)
        when (val state = detailViewModel.state.first()) {

            is TransportationDetailState.Error -> {}
            is TransportationDetailState.Loading -> {}
            is TransportationDetailState.TransportationDataSuccess -> {
                result = state.transportation
            }
        }

        verify(
            getTransportationDetailUseCase,
            times(1)
        ).invoke(id)
        TestCase.assertEquals(detailItem, result)
    }

    @Test
    fun whenGetTransportationDetailUseCaseIsError_DataError() = runBlocking {

        var result: String? = null
        whenever(getTransportationDetailUseCase.invoke(id)).thenReturn(
            listOf(
                GetTransportationDetailUseCase.GetTransportationDetailUseCaseState.Error(
                    errorText
                )
            ).asFlow()
        )

        detailViewModel.getTransportations(id)
        when (val state = detailViewModel.state.first()) {

            is TransportationDetailState.Error -> {
                result = state.message
            }
            is TransportationDetailState.Loading -> {}
            is TransportationDetailState.TransportationDataSuccess -> {}
        }

        verify(
            getTransportationDetailUseCase,
            times(1)
        ).invoke(id)
        TestCase.assertEquals(errorText, result)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}