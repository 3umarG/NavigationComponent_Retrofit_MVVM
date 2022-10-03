package com.example.navigationbarwithretrofit.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.navigationbarwithretrofit.ui.screens.CommentFragmentArgs
import com.example.navigationbarwithretrofit.R

class CommentFragment : Fragment() {
    private lateinit var tvPostID : TextView
    private lateinit var tvName : TextView
    private lateinit var tvEmail : TextView
    private val args by navArgs<CommentFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        tvEmail = view.findViewById(R.id.tvEmail)
        tvPostID = view.findViewById(R.id.tvPostId)
        tvName = view.findViewById(R.id.tvName)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvEmail.text = args.comment.email
        tvName.text = args.comment.name
        tvPostID.text = args.comment.postId.toString()
    }

}