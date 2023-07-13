package com.furkan.core.infrastructure

interface StringResourceProvider {
    fun getString(stringResId: Int): String
}