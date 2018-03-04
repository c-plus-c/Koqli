package com.example.koqli.ui.screen.items.feeds

import android.arch.lifecycle.ViewModelProviders
import com.example.koqli.ui.screen.items.ItemListFragment

/**
 * Created by biwaishi on 2018/03/04.
 */

class FeedListFragment : ItemListFragment<FeedListFragmentViewModel>() {
    override fun createViewModel(): FeedListFragmentViewModel {
        return ViewModelProviders.of(this).get(FeedListFragmentViewModel::class.java)
    }
}