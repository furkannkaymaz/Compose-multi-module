package com.furkan.presentation.search

import com.furkan.presentation.home.HomeScreenData
import com.furkan.presentation.search.SearchScreenData.errorMessage
import com.furkan.presentation.search.SearchScreenData.searchFail
import com.furkan.presentation.search.SearchScreenData.searchQueryHome
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.usecase.GetTransportationUseCase
import com.furkan.usecase.SearchTransportationUseCase
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
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel

    @Mock
    private lateinit var searchTransportationUseCase: SearchTransportationUseCase

    @Mock
    private lateinit var getTransportationUseCase: GetTransportationUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = SearchViewModel(getTransportationUseCase, searchTransportationUseCase)
    }

    @Test
    fun whenSearchSearchTransportationUseCaseIsTransportationDataSuccess_TransportationDataSuccessReturn() = runBlocking {

        var result: TransportationModelUi? = null
        whenever(searchTransportationUseCase.searchTransportationByType(searchQueryHome)).thenReturn(
            listOf(
                SearchTransportationUseCase.SearchTransportationUseCaseState.TransportationDataSuccess(
                    SearchScreenData.transportationList
                )
            ).asFlow()
        )

        viewModel.searchTransportation(searchQueryHome)
        when (val state = viewModel.state.first()) {
            is TransportationSearchState.Error -> {}
            is TransportationSearchState.Loading -> {}
            is TransportationSearchState.TransportationDataSuccess -> {
                result = state.transportation
            }
        }

        verify(searchTransportationUseCase, times(1)).searchTransportationByType(searchQueryHome)
        TestCase.assertEquals(HomeScreenData.transportationList, result)
    }

    @Test
    fun whenSearchSearchTransportationUseCaseIsDataNotFound_TransportationDataNotFoundReturn() = runBlocking {
        //given
        var result: String? = null
        whenever(searchTransportationUseCase.searchTransportationByType(searchFail)).thenReturn(
            listOf(
                SearchTransportationUseCase.SearchTransportationUseCaseState.TransportationDataNotFound(
                    errorMessage
                )
            ).asFlow()
        )

        viewModel.searchTransportation(searchFail)
        when (val state = viewModel.state.first()) {
            is TransportationSearchState.Error -> {
                result = state.message
            }
            else -> Unit
        }
        verify(searchTransportationUseCase, times(1)).searchTransportationByType(searchFail)
        TestCase.assertEquals(errorMessage, result)
    }

    @Test
    fun whenSearchSearchTransportationUseCaseError_TransportationErrorReturn() = runBlocking {

        var result: String? = null
        whenever(searchTransportationUseCase.searchTransportationByType(searchFail)).thenReturn(
            listOf(
                SearchTransportationUseCase.SearchTransportationUseCaseState.Error(
                    errorMessage
                )
            ).asFlow()
        )

        viewModel.searchTransportation(searchFail)
        when (val state = viewModel.state.first()) {
            is TransportationSearchState.Error -> {
                result = state.message
            }
            else -> Unit
        }

        verify(searchTransportationUseCase, times(1)).searchTransportationByType(searchFail)
        TestCase.assertEquals(errorMessage, result)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}