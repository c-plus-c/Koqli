package com.example.koqli.ui.screen.Items

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.koqli.application.Application
import com.example.koqli.application.Usecases
import com.example.koqli.domain.item.Item

/**
 * Created by biwaishi on 2017/10/22.
 */
class ItemListFragmentViewModel : ViewModel() {

    companion object {
        val PerPage: Int = 10
    }

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val resultList: MutableLiveData<List<Item>> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    var currentPage = 1

    fun getItemsAll(usecases: Usecases) {

        if(isLoading.value == true){
            return
        }

        isLoading.value = true

        usecases.getItems(currentPage++, PerPage)
                .exec({
                    resultList.postValue(it)
                }, {
                    error.postValue(it)
                }, {
                    isLoading.value = false
                })
    }
}