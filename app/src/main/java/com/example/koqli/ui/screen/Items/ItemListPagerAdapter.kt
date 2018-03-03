package com.example.koqli.ui.screen.Items

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by biwaishi on 2017/10/22.
 */

class ItemListPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment? {
        when{
            position == 0 -> {
                return ItemListFragment.newInstance(ItemListFragment.DataListType.FEED)
            }
            position == 1 -> {
                return ItemListFragment.newInstance(ItemListFragment.DataListType.FEED)
            }
            position == 2 -> {
                return ItemListFragment.newInstance(ItemListFragment.DataListType.FEED)
            }
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "page" + position.toString()
    }

}