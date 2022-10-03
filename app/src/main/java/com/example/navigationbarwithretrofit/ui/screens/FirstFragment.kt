package com.example.navigationbarwithretrofit.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationbarwithretrofit.R
import com.example.navigationbarwithretrofit.model.CommentModel
import com.example.navigationbarwithretrofit.ui.adapters.RVAdapter
import com.example.navigationbarwithretrofit.ui.viewmodel.CommentsViewModel

class FirstFragment : Fragment() {
    private lateinit var rv1: RecyclerView
    private lateinit var viewModel: CommentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        rv1 = view.findViewById(R.id.rv1)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[CommentsViewModel::class.java]
        viewModel.getComments(1)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            val rvAdapter = RVAdapter(it ,object : OnItemClickedListener{
                override fun onItemClicked(comment: CommentModel) {
                    val actions = FirstFragmentDirections.actionFirstFragmentToCommentFragment(comment)
                    findNavController().navigate(actions)

                }
            })
            rv1.adapter = rvAdapter
            rv1.layoutManager = LinearLayoutManager(context)
        })


    }

}