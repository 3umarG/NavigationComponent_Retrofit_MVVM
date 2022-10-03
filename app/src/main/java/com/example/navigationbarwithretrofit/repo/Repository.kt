package com.example.navigationbarwithretrofit.repo

import com.example.navigationbarwithretrofit.data.RetrofitClient

class Repository {
    companion object {
        fun getComments(postId : Int) = RetrofitClient.apiInterface.getComments(postId)
    }
}