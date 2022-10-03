package com.example.navigationbarwithretrofit.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationbarwithretrofit.R
import com.example.navigationbarwithretrofit.model.CommentModel
import com.example.navigationbarwithretrofit.ui.adapters.RVAdapter
import com.example.navigationbarwithretrofit.ui.viewmodel.CommentsViewModel

class SecondFragment : Fragment() {
    private lateinit var viewModel: CommentsViewModel
    private lateinit var rv2 : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        rv2 = view.findViewById(R.id.rv2)
        viewModel = ViewModelProvider(requireActivity())[CommentsViewModel::class.java]
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getComments(2)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            val rvAdapter = RVAdapter(it , object : OnItemClickedListener{
                override fun onItemClicked(comment: CommentModel) {
                    val action = SecondFragmentDirections.actionSecondFragmentToCommentFragment2(comment)
                    findNavController().navigate(action)
                }
            })
            rv2.adapter = rvAdapter
            rv2.layoutManager = LinearLayoutManager(context)
        })
    }

}