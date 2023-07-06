package com.furkan.base

interface BaseMapper<I, O> {
    fun map(input: I): O
}