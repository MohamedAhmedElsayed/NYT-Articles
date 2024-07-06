package com.nyt.articles.core.data.remote.model

sealed class Resource<T>(
    open val data: T? = null,
    open val remoteError: RemoteError? = null,
) {
    data class Success<T>(override val data: T) : Resource<T>(data)
    data class Error<T>(
        override val remoteError: RemoteError,
        override val data: T? = null,
        val code: Int
    ) : Resource<T>(data, remoteError)


}
