package com.example.koqli.ui.screen.items

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.koqli.application.Application
import com.example.koqli.application.Usecases
import com.example.koqli.domain.item.Item
import com.example.koqli.usecase.BaseRxUseCase

/**
 * Created by biwaishi on 2017/10/22.
 */
abstract class ItemListFragmentViewModel : ViewModel() {

    companion object {
        val PER_PAGE: Int = 10
    }

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val resultList: MutableLiveData<List<Item>> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    var currentPage = 1

    fun getItemsAll(application: Application) {

        if(isLoading.value == true){
            return
        }

        isLoading.value = true

        getItems(application, currentPage++)
                .exec({
                    resultList.postValue(it)
                }, {
                    error.postValue(it)
                }, {
                    isLoading.value = false
                })
    }

    protected abstract fun getItems(application: Application, currentPage: Int): BaseRxUseCase<List<Item>>
}