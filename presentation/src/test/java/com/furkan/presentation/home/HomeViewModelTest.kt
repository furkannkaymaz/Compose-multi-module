package com.furkan.presentation.home

import com.furkan.presentation.home.HomeScreenData.errorText
import com.furkan.presentation.home.HomeScreenData.transportationList
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.usecase.GetTransportationUseCase
import io.mockk.clearAllMocks
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Test
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var getTransportationUseCase: GetTransportationUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        homeViewModel = HomeViewModel(getTransportationUseCase)
    }

    @Test
    fun whenGetTransportationUseCaseIsData_TransportationDataSuccessReturn() = runBlocking {

        //given
        var result: TransportationModelUi? = null
        whenever(getTransportationUseCase.invoke()).thenReturn(
            listOf(
                GetTransportationUseCase.GetTransportationUseCaseState.Data(
                    transportationList
                )
            ).asFlow()
        )
        homeViewModel.setState(TransportationState.TransportationDataSuccess(transportationList))

        //when
        when (val state = homeViewModel.state.first()) {
            is TransportationState.Error -> {}
            is TransportationState.Loading -> {}
            is TransportationState.TransportationDataSuccess -> {
                result = state.transportation
            }
        }
        //then
        verify(getTransportationUseCase, times(1)).invoke()
        assertEquals(transportationList, result)
    }

    @Test
    fun whenGetTransportationUseCase_TransportationError() = runBlocking {
        var result: String? = null
        whenever(getTransportationUseCase.invoke()).thenReturn(
            listOf(
                GetTransportationUseCase.GetTransportationUseCaseState.Error(
                    errorText
                )
            ).asFlow()
        )

        homeViewModel.setState(TransportationState.Error(errorText))

        when (val state = homeViewModel.state.first()) {
            is TransportationState.Error -> {
                result = state.message
            }
            is TransportationState.Loading -> {}
            is TransportationState.TransportationDataSuccess -> {}
        }

        verify(getTransportationUseCase, times(1)).invoke()
        assertEquals(errorText, result)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}

