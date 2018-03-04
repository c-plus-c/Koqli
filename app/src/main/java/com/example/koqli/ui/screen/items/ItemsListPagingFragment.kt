package com.example.koqli.ui.screen.items

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koqli.R
import com.example.koqli.databinding.FragmentItemsListPagingBinding

class ItemsListPagingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentItemsListPagingBinding>(inflater, R.layout.fragment_items_list_paging, container, false)

        binding.coordinatorTabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = ItemListPagerAdapter(fragmentManager!!)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): ItemsListPagingFragment {
            val fragment = ItemsListPagingFragment()
            return fragment
        }
    }
}// Required empty public constructor
