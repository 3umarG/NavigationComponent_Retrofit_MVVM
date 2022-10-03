package com.example.navigationbarwithretrofit.data

import com.example.navigationbarwithretrofit.model.CommentModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("comments")
    fun getComments(@Query("postId") postId : Int) : Call<List<CommentModel>>
}