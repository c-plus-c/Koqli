package com.example.koqli.ui.screen.items.all

import android.arch.lifecycle.ViewModelProviders
import com.example.koqli.ui.screen.items.ItemListFragment

/**
 * Created by biwaishi on 2018/03/04.
 */

class AllListFragment : ItemListFragment<AllListFragmentViewModel>() {
    override fun createViewModel(): AllListFragmentViewModel {
        return ViewModelProviders.of(this).get(AllListFragmentViewModel::class.java)
    }

}