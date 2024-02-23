package com.arpit.play.billing

class NetworkViewModel {
    private val loginRepository: NetworkRequestRepository = NetworkRequestRepository()


    fun makeLoginRequest() {
        loginRepository.makeLoginRequest(object : RepositoryCallback<String> {

            override fun onComplete(result: Result<String>) {
                when (result) {
                    is Result.Success -> {
                        println("loginRepository = ${result.data}")
                    }

                    is Result.Failure -> {
                        println("loginRepository = ${result.error}")
                    }
                }
            }

        })
    }
}