package com.example.navigationbarwithretrofit.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationbarwithretrofit.R
import com.example.navigationbarwithretrofit.model.CommentModel
import com.example.navigationbarwithretrofit.ui.adapters.RVAdapter
import com.example.navigationbarwithretrofit.ui.viewmodel.CommentsViewModel

class ThirdFragment : Fragment() {

    private lateinit var viewModel: CommentsViewModel
    private lateinit var rv3: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        rv3 = view.findViewById(R.id.rv3)
        viewModel = ViewModelProvider(requireActivity())[CommentsViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getComments(3)
        viewModel.liveData.observe(viewLifecycleOwner) {
            val rvAdapter = RVAdapter(it, object : OnItemClickedListener {
                override fun onItemClicked(comment: CommentModel) {
                    val action =
                        ThirdFragmentDirections.actionThirdFragmentToCommentFragment(comment)
                    findNavController().navigate(action)
                }
            })
            rv3.adapter = rvAdapter
            rv3.layoutManager = LinearLayoutManager(context)
        }
    }

}