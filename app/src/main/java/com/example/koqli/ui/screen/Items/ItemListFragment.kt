package com.example.koqli.ui.screen.Items

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.koqli.R
import com.example.koqli.application.Application
import com.example.koqli.databinding.FragmentItemListBinding
import com.example.koqli.domain.item.Item
import com.jakewharton.rxbinding2.support.v7.widget.scrollEvents
import com.uber.autodispose.LifecycleScopeProvider
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.kotlin.autoDisposeWith
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toSingle
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * Created by biwaishi on 2017/10/22.
 */

class ItemListFragment: Fragment(){

    enum class DataListType(val rawValue: Int) {
        FREE_WORD(1),
        USER(2),
        TAG(3),
        FEED(4)
    }

    private lateinit var viewModel: ItemListFragmentViewModel

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

        viewModel = ViewModelProviders.of(this).get(ItemListFragmentViewModel::class.java)
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
                    viewModel.getItemsAll(Application.getApplicationFromContext(context!!).usecases)
                })
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getItemsAll(Application.getApplicationFromContext(context!!).usecases)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    companion object {
        private val DATA_LIST_TYPE = "data_list_type"
        fun newInstance(dataListType: DataListType): ItemListFragment {
            val frag = ItemListFragment()
            val b = Bundle()
            b.putInt(DATA_LIST_TYPE, dataListType.rawValue)
            frag.setArguments(b)
            return frag
        }
    }
}