package com.nyt.articles.domain

interface SuspendableUseCase<in I, out O> {
    suspend operator fun invoke(input: I): O
}
