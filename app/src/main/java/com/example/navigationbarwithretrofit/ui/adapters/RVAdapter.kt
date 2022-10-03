package com.example.navigationbarwithretrofit.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationbarwithretrofit.R
import com.example.navigationbarwithretrofit.model.CommentModel
import com.example.navigationbarwithretrofit.ui.screens.OnItemClickedListener

class RVAdapter(
    private val comments: List<CommentModel>,
    private val listener: OnItemClickedListener
) :
    RecyclerView.Adapter<RVAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val tvBody = v.findViewById<TextView>(R.id.tvBody)
        private val tvEmail = v.findViewById<TextView>(R.id.tvEmail)

        fun bind(comment: CommentModel) {
            tvBody.text = comment.body
            tvEmail.text = comment.email
        }

        fun click(comment: CommentModel) {
            v.setOnClickListener {
                listener.onItemClicked(comment)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_recycler_view, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])
        holder.click(comments[position])
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}