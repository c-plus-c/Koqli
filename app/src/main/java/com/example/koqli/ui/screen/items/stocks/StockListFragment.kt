package com.example.koqli.ui.screen.items.stocks

import android.arch.lifecycle.ViewModelProviders
import com.example.koqli.ui.screen.items.ItemListFragment

/**
 * Created by biwaishi on 2018/03/04.
 */

class StockListFragment : ItemListFragment<StockListFragmentViewModel>() {
    override fun createViewModel(): StockListFragmentViewModel {
        return ViewModelProviders.of(this).get(StockListFragmentViewModel::class.java)
    }
}