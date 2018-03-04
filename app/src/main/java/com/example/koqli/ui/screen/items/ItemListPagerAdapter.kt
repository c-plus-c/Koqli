package com.example.koqli.ui.screen.items

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.koqli.ui.screen.items.all.AllListFragment
import com.example.koqli.ui.screen.items.feeds.FeedListFragment
import com.example.koqli.ui.screen.items.stocks.StockListFragment

/**
 * Created by biwaishi on 2017/10/22.
 */

class ItemListPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    private enum class ItemListType(val index:Int, val title: String){
        ALL(0, "全て"),
        FEED(1, "フィード"),
        STOCK(2, "ストック"),
    }

    override fun getItem(position: Int): Fragment? {
        when (position){
            ItemListType.ALL.index -> {
                return AllListFragment()
            }
            ItemListType.FEED.index -> {
                return FeedListFragment()
            }
            ItemListType.STOCK.index -> {
                return StockListFragment()
            }
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return ItemListType.values().firstOrNull { it.index == position }?.title ?: "不明"
    }

}