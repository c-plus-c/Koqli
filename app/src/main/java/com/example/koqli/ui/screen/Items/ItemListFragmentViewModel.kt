package com.example.koqli.ui.screen.Items

import android.content.Context
import com.example.koqli.domain.item.Item
import com.example.koqli.ui.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import jp.keita.kagurazaka.rxproperty.RxProperty

/**
 * Created by biwaishi on 2017/10/22.
 */
class ItemListFragmentViewModel(override val context: Context, val code: String?): ViewModel {

    companion object {
        val PerPage: Int = 10
    }

    val isLoading :RxProperty<Boolean> = RxProperty()
    val resultList : RxProperty<MutableList<Item>> = RxProperty()
    val error: RxProperty<Throwable> = RxProperty()
    override var disposables: CompositeDisposable = CompositeDisposable()

    fun getItemsAll(page: Int) {
        isLoading.set(true);
        application.usecases.getItems(page, PerPage)
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
}