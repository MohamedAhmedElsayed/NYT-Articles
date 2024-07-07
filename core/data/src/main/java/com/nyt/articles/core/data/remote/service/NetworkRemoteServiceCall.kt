package com.nyt.articles.core.data.remote.service

import com.nyt.articles.core.data.remote.model.RemoteError
import com.nyt.articles.core.data.remote.model.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

interface NetworkRemoteServiceCall {
    //centralized function to handle api calls
    suspend fun <T> safeRemoteCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(dispatcher) {
            try {
                val response = apiCall.invoke()
                Resource.Success(response)
            } catch (throwable: Exception) {
//                Log.e("API Call Error", "${throwable.message} $throwable")
                throwable.fromExceptionToRemoteError()
            }
        }
    }

    //based on the failure we can change the logic it is simple for now
    private fun <T> Exception.fromExceptionToRemoteError() = when (this) {
        is IOException -> Resource.Error<T>(RemoteError.ConnectionError, code = -1)
        is HttpException -> {
            Resource.Error(
                RemoteError.ServerError(
                    response()?.errorBody()?.string(), code()
                ),
                code = code(),
            )
        }

        else -> {
            Resource.Error(RemoteError.GeneralError, code = -1)
        }
    }


}
