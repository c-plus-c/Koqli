package com.example.koqli.ui.screen.Items

import android.support.v4.app.Fragment
import android.widget.LinearLayout
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.annotation.ColorRes
import android.view.View
import com.example.koqli.R
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * Created by biwaishi on 2017/10/22.
 */

class ItemListFragment: Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_item_list, null)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fragment_item_list_root.setBackgroundResource(arguments.getInt(BACKGROUND_COLOR))
    }

    companion object {
        private val BACKGROUND_COLOR = "background_color"
        fun newInstance(@ColorRes IdRes: Int): ItemListFragment {
            val frag = ItemListFragment()
            val b = Bundle()
            b.putInt(BACKGROUND_COLOR, IdRes)
            frag.setArguments(b)
            return frag
        }
    }
}