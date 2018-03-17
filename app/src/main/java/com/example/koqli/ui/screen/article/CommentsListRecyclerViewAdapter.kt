package com.example.koqli.ui.screen.article

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.koqli.R
import com.example.koqli.databinding.FragmentArticleCommentItemBinding
import com.example.koqli.domain.comment.Comment
import com.example.koqli.domain.user.User
import ru.noties.markwon.Markwon

/**
 * Created by biwaishi on 2018/03/17.
 */
class CommentsListRecyclerViewAdapter(val onTappedContributor: ((User) -> Unit)?) : RecyclerView.Adapter<CommentsListRecyclerViewAdapter.CommentListRecyclerViewHolder>() {
    val commentList: MutableList<Comment> = mutableListOf()
    var isLoading = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsListRecyclerViewAdapter.CommentListRecyclerViewHolder {
        val binding = DataBindingUtil.inflate<FragmentArticleCommentItemBinding>(LayoutInflater.from(parent.context), R.layout.fragment_article_comment_item, parent, false)
        return CommentListRecyclerViewHolder(binding)
    }

    fun addItems(dataList: Collection<Comment>) {
        commentList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = commentList.size

    override fun onBindViewHolder(holder: CommentsListRecyclerViewAdapter.CommentListRecyclerViewHolder, position: Int) {
        val item = commentList.get(position)
        holder.binding.setVariable(BR.viewModel, item)

        item.body?.let {
            Markwon.setMarkdown(holder.binding.articleCommentContent, it)
        }

        val requestOptions = RequestOptions()
        requestOptions.centerCrop()

        item.user?.let { user ->
            Glide
                    .with(holder.binding.root.context)
                    .load(user.profileImageUrl)
                    .apply(requestOptions)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(holder.binding.articleCommentIcon)

            holder.binding.articleCommentIcon.setOnClickListener {
                onTappedContributor?.invoke(user)
            }

            holder.binding.articleCommentContributor.setOnClickListener {
                onTappedContributor?.invoke(user)
            }
        }
        holder.binding.executePendingBindings()
    }

    class CommentListRecyclerViewHolder(val binding: FragmentArticleCommentItemBinding) : RecyclerView.ViewHolder(binding.root)
}