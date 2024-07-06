package com.nyt.articles.core.data.remote.service

import android.util.Log
import com.nyt.articles.core.data.remote.model.RemoteError
import com.nyt.articles.core.data.remote.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

interface NetworkRemoteServiceCall {

    /**
     * safeRemoteCall
     * @param apiCall as suspend fn to call api
     * pass suspend api fn as parameter to safeRemoteCall fn
     * invoke Api at IO thread and handle logic
     * @return Resource< T>  hase success state data and failure state data
     */
    suspend fun <T> safeRemoteCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiCall.invoke()
                Resource.Success(response)
            } catch (throwable: Exception) {
                Log.e("API Call Error", "${throwable.message} $throwable")
                throwable.fromExceptionToRemoteError()
            }
        }
    }

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
