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
            //suspended means that whole coroutine will get suspended when suspend function is called,
            //but if another new coroutine is called next to it it will not get suspended like here.
            //one coroutine suspension will not affect other, only coroutine where suspended function is called will get
            // suspended.
            val result1 = launch { loginRepository.makeLoginRequest() }
            val result2 = launch { loginRepository.makeLogRequest() }
//            when (result1) {
//                is Result.Success -> {
//                    println("loginRepository = view model ${Thread.currentThread().name}")
//                    data.value = "Success"
//                    println("loginRepository = ${result1.data}")
//                }
//
//                is Result.Failure -> {
//                    data.value = ("Failure")
//                    println("loginRepository = ${result1.error}")
//                }
//            }
//            when (result2) {
//                is Result.Success -> {
//                    println("loginRepository = view model ${Thread.currentThread().name}")
//                    data.value = "Success"
//                    println("loginRepository = ${result2.data}")
//                }
//
//                is Result.Failure -> {
//                    data.value = ("Failure")
//                    println("loginRepository = ${result2.error}")
//                }
//            }
        }

    }

}
