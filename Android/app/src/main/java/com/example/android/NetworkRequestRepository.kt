package com.example.android

import android.os.Handler
import java.util.concurrent.ExecutorService


class NetworkRequestRepository {

    fun makeLoginRequest(
        executorService: ExecutorService,
        mainThreadHandler: Handler,
        callback: RepositoryCallback<String>
    ) {
        executorService.execute {
            try {
                println("loginRepository = ${Thread.currentThread().name}")
                Thread.sleep(2000)
                callback.onComplete(Result.Success("Success"))
            } catch (e: Exception) {
                callback.onComplete(Result.Failure("Something went wrong"))
            }
        }
    }
}

interface RepositoryCallback<T> {
    fun onComplete(result: Result<T>)
}