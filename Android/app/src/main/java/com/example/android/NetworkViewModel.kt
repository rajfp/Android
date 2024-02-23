package com.example.android

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.ExecutorService

class NetworkViewModel {
    private val loginRepository: NetworkRequestRepository = NetworkRequestRepository()
    val data = MutableLiveData<String>()
    fun makeLoginRequest(executorService: ExecutorService, mainThreadHandler: Handler) {
        loginRepository.makeLoginRequest(executorService, mainThreadHandler, object :
            RepositoryCallback<String> {

            override fun onComplete(result: Result<String>) {
                when (result) {
                    is Result.Success -> {
                        data.postValue( "Success")
                        println("loginRepository = ${result.data}")
                    }

                    is Result.Failure -> {
                        data.postValue("Failure")
                        println("loginRepository = ${result.error}")
                    }
                }
            }

        })
    }
}