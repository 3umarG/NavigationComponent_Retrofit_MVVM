package com.example.navigationbarwithretrofit.ui.screens

import com.example.navigationbarwithretrofit.model.CommentModel

interface OnItemClickedListener {
    fun onItemClicked(comment : CommentModel)
}