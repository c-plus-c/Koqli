package com.example.koqli.ui.screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.koqli.R
import com.example.koqli.domain.item.Item
import com.example.koqli.ui.screen.article.ArticleFragment
import com.example.koqli.ui.screen.items.ItemsListPagingFragment
import com.michaelflisar.rxbus2.RxBusBuilder
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainScreenActivity : AppCompatActivity() {

    val ITEMLISTPAGERFRAGMENT_BACKSTACK_KEY = "itemlistpagerfragment_backstack_key"
    val ARTICLEFRAGMENT_BACKSTACK_KEY = "articlefragment_backstack_key"

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen_activity)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_content, ItemsListPagingFragment.newInstance())
        transaction.commit()

        RxBusBuilder.create(Item::class.java)
                .withKey("open_item_detail")
                .build()
                .subscribe({ item ->
                    item?.let {
                        changeScreenToDetail(item)
                    }
                })
                .addTo(compositeDisposable)

        RxBusBuilder.create(String::class.java)
                .withKey("open_entries")
                .build()
                .subscribe({
                    changeBackScreenToEntries()
                })
                .addTo(compositeDisposable)
    }

    fun changeBackScreenToEntries() {
        supportFragmentManager.popBackStack()
    }

    fun changeScreenToDetail(item: Item) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            add(R.id.main_content, ArticleFragment.newInstance(item))
            addToBackStack(ARTICLEFRAGMENT_BACKSTACK_KEY)
        }.commit()
        supportFragmentManager.executePendingTransactions()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
