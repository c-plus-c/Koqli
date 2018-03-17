package com.example.koqli.ui.screen.article

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.koqli.BR
import com.example.koqli.R
import com.example.koqli.application.Application
import com.example.koqli.databinding.DetailTagBinding
import com.example.koqli.databinding.FragmentArticleBinding
import com.example.koqli.domain.item.Item
import com.michaelflisar.rxbus2.RxBus
import ru.noties.markwon.Markwon

/**
 * Created by biwaishi on 2018/03/04.
 */
class ArticleFragment : Fragment() {

    lateinit var item: Item

    private lateinit var viewModel: ArticleFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        item = arguments?.getSerializable("item") as Item
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentArticleBinding>(inflater, R.layout.fragment_article, container, false)


        val requestOptions = RequestOptions()
        requestOptions.centerCrop()

        context?.let { context ->
            Glide
                    .with(context)
                    .load(item.user?.profileImageUrl)
                    .apply(requestOptions)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.contributorIcon)
        }


        viewModel = ViewModelProviders.of(this).get(ArticleFragmentViewModel::class.java)

        viewModel.resultContent.observe(this, Observer { item ->

            context?.let {
                item?.body?.let {
                    Markwon.setMarkdown(binding.markdownContentView, it)
                }
            }
            binding.setVariable(BR.viewModel, viewModel)
            binding.executePendingBindings()
        })

        val layoutManager = LinearLayoutManager(context)
        binding.commentsList.layoutManager = layoutManager
        val commentsListRecyclerViewAdapter = CommentsListRecyclerViewAdapter({
            //TODO: ユーザ名がタップされた時のアクションを行う
        })
        binding.commentsList.adapter = commentsListRecyclerViewAdapter

        viewModel.resultComments.observe(this, Observer {
            it?.let { itemList ->
                activity?.let { fragmentActivity ->
                    fragmentActivity.runOnUiThread {
                        binding.commentsListHeader.visibility = if (itemList.isNotEmpty()) {
                            View.VISIBLE
                        } else {
                            View.GONE
                        }
                        commentsListRecyclerViewAdapter.addItems(itemList.toMutableList())
                    }
                }
            }
        })

        binding.toolbar.setNavigationOnClickListener {
            RxBus.get().withKey("open_entries").send("null")
        }

        item.tags?.forEach { tagging ->
            val layoutInflater = LayoutInflater.from(binding.root.context)
            val tagLayout = DataBindingUtil.inflate<DetailTagBinding>(layoutInflater, R.layout.detail_tag, null, false)
            val marginLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            marginLayoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.between_detail_tag_and_tag)
            tagLayout.root.layoutParams = marginLayoutParams
            tagLayout.setVariable(BR.tagging, tagging)

            tagLayout.root.setOnClickListener {
                // onTappedTag?.invoke(tagging)
            }

            binding.tagList.addView(tagLayout.root)
            binding.executePendingBindings()
        }

        binding.fab.setOnClickListener {
            context?.let { context ->
                viewModel.toggleStock(Application.getApplicationFromContext(context), item.identity.value)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            viewModel.loadContent(Application.getApplicationFromContext(context), item.identity.value)
            viewModel.loadIsStocked(Application.getApplicationFromContext(context), item.identity.value)
            viewModel.loadComments(Application.getApplicationFromContext(context), item.identity.value)
        }

    }


    companion object {
        fun newInstance(item: Item): ArticleFragment {
            val articleFragment = ArticleFragment()
            val args = Bundle()
            args.putSerializable("item", item)
            articleFragment.arguments = args
            return articleFragment
        }
    }
}