package com.example.koqli.ui.screen.items

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.koqli.R
import com.example.koqli.application.Application
import com.example.koqli.databinding.FragmentItemListBinding
import com.jakewharton.rxbinding2.support.v7.widget.scrollEvents
import io.reactivex.disposables.Disposable


/**
 * Created by biwaishi on 2017/10/22.
 */

abstract class ItemListFragment<VM: ItemListFragmentViewModel>: Fragment(){

    private lateinit var viewModel: VM

    private lateinit var disposable: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentItemListBinding>(inflater, R.layout.fragment_item_list, container, false)

        val layoutManager = LinearLayoutManager(context)
        binding.itemList.layoutManager = layoutManager
        val itemListRecyclerViewAdapter = ItemListRecyclerViewAdapter({

        },{

        },{

        })


        binding.itemList.adapter = itemListRecyclerViewAdapter

        viewModel = createViewModel()
        viewModel.resultList.observe(this, Observer{
            it?.let { itemList ->
                activity?.let { fragmentActivity ->
                    fragmentActivity.runOnUiThread{
                        itemListRecyclerViewAdapter.addItems(itemList.toMutableList())
                    }
                }
            }
        })

        viewModel.isLoading.observe(this, Observer {
            it?.let {
                itemListRecyclerViewAdapter.isLoading = it
                if(!it) {
                    binding.itemList.stopScroll()
                }
            }

        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(context, "データの取得に失敗しました", Toast.LENGTH_LONG).show()
        })

        disposable = binding.itemList.scrollEvents()
                .filter{itemListRecyclerViewAdapter.itemCount - 1 <= layoutManager.findLastVisibleItemPosition()}
                .take(1)
                .repeat()
                .subscribe({
                    viewModel.getItemsAll(Application.getApplicationFromContext(context!!))
                })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        context?.let{
            viewModel.getItemsAll(Application.getApplicationFromContext(it))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    abstract fun createViewModel(): VM
}