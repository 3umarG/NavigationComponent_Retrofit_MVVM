package com.example.navigationbarwithretrofit.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationbarwithretrofit.model.CommentModel
import com.example.navigationbarwithretrofit.repo.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData <List<CommentModel>>()
    val liveData = mutableLiveData as LiveData <List<CommentModel>>

    fun getComments(postId: Int) {
        val call: Call<List<CommentModel>> = Repository.getComments(postId)

        call.enqueue(object : Callback<List<CommentModel>> {
            override fun onResponse(
                call: Call<List<CommentModel>>,
                response: Response<List<CommentModel>>
            ) {
                if (response.isSuccessful){
                    mutableLiveData.value = response.body() as List<CommentModel>
                }else {
                    Log.d("Response", "Failure!!!")
                }

            }

            override fun onFailure(call: Call<List<CommentModel>>, t: Throwable) {
                mutableLiveData.value = listOf()
            }
        })
    }

}