package com.example.koqli.ui.screen.article

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koqli.R
import com.example.koqli.databinding.FragmentArticleBinding
import com.example.koqli.domain.item.Item
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs

/**
 * Created by biwaishi on 2018/03/04.
 */
@FragmentWithArgs
class ArticleFragment : Fragment() {

    @Arg(required = false)
    lateinit var item: Item

    private lateinit var viewModel: ArticleFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentArgs.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentArticleBinding>(inflater, R.layout.fragment_article, container, false)

        return binding.root
    }
}