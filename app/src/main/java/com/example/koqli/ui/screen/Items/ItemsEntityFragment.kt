package com.example.koqli.ui.screen.Items

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.koqli.R
import kotlinx.android.synthetic.main.fragment_items_entity.*

class ItemsEntityFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_items_entity, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_items_entity_floating_action_button_search.setOnClickListener {
            val bottomSheetBehavior = BottomSheetBehavior.from(fragment_items_entity_floating_search_ui)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        fragment_items_entity_item_list_view_pager.adapter = ItemListPagerAdapter(fragmentManager)
        fragment_items_entity_item_list_view_pager_tab.setupWithViewPager(fragment_items_entity_item_list_view_pager)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): ItemsEntityFragment {
            val fragment = ItemsEntityFragment()
            return fragment
        }
    }
}// Required empty public constructor
