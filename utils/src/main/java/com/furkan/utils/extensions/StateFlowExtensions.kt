package com.furkan.utils.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> StateFlow<T>.collectWhenResumed(
    lifecycleOwner: LifecycleOwner,
    action: suspend (value: T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        this@collectWhenResumed
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .collectLatest(action)
    }
}

/**If you only need to perform lifecycle-aware collection on a single flow*/
fun <T> StateFlow<T>.listen(lifecycleOwner: LifecycleOwner, action: suspend (value: T) -> Unit) {
    lifecycleOwner.lifecycleScope.launch {
        this@listen
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .collectLatest(action)
    }
}

suspend fun <T> StateFlow<T>.listen(action: suspend (value: T) -> Unit) {
    this@listen.collectLatest(action)
}