package com.example.android

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService

class NetworkViewModel : ViewModel() {
    private val loginRepository: NetworkRequestRepository = NetworkRequestRepository()
    val data = MutableLiveData<String>()
    fun makeLoginRequest(executorService: ExecutorService, mainThreadHandler: Handler) {
        //We can use dispatchers.IO here and remove withContext(Dispatchers.IO) from repository or do like currently done.
        //switch to Background here or switch to Background in repository using withContext(Dispatchers.IO)
        // and stay here in main thread or vice versa.

        viewModelScope.launch {
            val result1 = launch { loginRepository.makeLoginRequest() }
            val result2 = launch { loginRepository.makeLoginRequest() }
//            println("loginRepository = ${result1.data}")
//            println("loginRepository = ${result2.data}")
//            when (result) {
//                is Result.Success -> {
//                    println("loginRepository = view model ${Thread.currentThread().name}")
//                    data.value = "Success"
//                    println("loginRepository = ${result.data}")
//                }
//
//                is Result.Failure -> {
//                    data.value = ("Failure")
//                    println("loginRepository = ${result.error}")
//                }
//            }
        }

    }

}
