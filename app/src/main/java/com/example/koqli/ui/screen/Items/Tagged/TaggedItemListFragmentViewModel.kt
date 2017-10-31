package com.example.koqli.ui.screen.Items.Users

import android.content.Context
import com.example.koqli.domain.item.Item
import com.example.koqli.domain.tag.Tag
import com.example.koqli.ui.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import jp.keita.kagurazaka.rxproperty.RxProperty

/**
 * Created by biwaishi on 2017/10/22.
 */
class TaggedItemListFragmentViewModel(override val context: Context, val tag: Tag): ViewModel {

    companion object {
        val PerPage: Int = 10
    }

    var currentPage:Int = 0
    val isLoading : RxProperty<Boolean> = RxProperty()
    val resultList : RxProperty<MutableList<Item>> = RxProperty()
    val error: RxProperty<Throwable> = RxProperty()
    override var disposables: CompositeDisposable = CompositeDisposable()

    private fun getItems(page: Int) {
        isLoading.set(true);
        application.usecases.getItemsByTagId(tag.identity.value,  page, PerPage)
                .compose {
                    it.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).doFinally{
                        isLoading.set(false)
                    }
                }
                .apply { disposables.add(this) }
                .exec({
                    resultList.set(it)
                }, {
                    error.set(it)
                })
    }

    fun getNextPage(){
        getItems(currentPage++)
    }
}