package com.nyt.articles.core.data.remote.model

sealed class RemoteError {
    data object ConnectionError : RemoteError()
    data object GeneralError : RemoteError()
    data class ServerError(val errorBody: String?, val errorCode: Int) : RemoteError()

    fun RemoteError.toErrorMessage() = when (this) {
        ConnectionError -> "Internet Connection Error"
        GeneralError -> "Something went wrong"
        is ServerError -> "Server Error $errorBody  with code $errorCode"
    }
}
