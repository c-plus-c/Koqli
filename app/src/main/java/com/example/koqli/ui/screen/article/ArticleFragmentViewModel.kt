package com.example.koqli.ui.screen.article

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.koqli.application.Application
import com.example.koqli.domain.comment.Comment
import com.example.koqli.domain.item.Item

/**
 * Created by biwaishi on 2018/03/04.
 */
class ArticleFragmentViewModel : ViewModel() {
    val isContentLoading: MutableLiveData<Boolean> = MutableLiveData()
    val resultContent: MutableLiveData<Item> = MutableLiveData()
    val isCommentsLoading: MutableLiveData<Boolean> = MutableLiveData()
    val resultComments: MutableLiveData<List<Comment>> = MutableLiveData()
    val isStockUpdating: MutableLiveData<Boolean> = MutableLiveData()
    val isStocking: MutableLiveData<Boolean> = MutableLiveData()
    val errors: MutableLiveData<Throwable> = MutableLiveData()

    fun loadContent(application: Application, itemId: String) {

        if (isCommentsLoading.value == true) {
            return
        }

        isContentLoading.postValue(true)

        application.usecases.getItem(itemId).exec({
            resultContent.postValue(it)
        }, {
            errors.postValue(it)
        }, {
            isContentLoading.postValue(false)
        })
    }

    fun loadComments(application: Application, itemId: String) {

        if (isCommentsLoading.value == true) {
            return
        }

        isCommentsLoading.postValue(true)

        application.usecases.getCommentsByItemId(itemId).exec({
            resultComments.postValue(it)
        }, {
            errors.postValue(it)
        }, {
            isCommentsLoading.postValue(false)
        })
    }

    fun loadIsStocked(application: Application, itemId: String) {

        isStockUpdating.postValue(true)
        application.usecases.isStockingItem(itemId)
                .exec({
                    isStocking.postValue(it)
                }, {
                    errors.postValue(it)
                }, {
                    isStocking.postValue(false)
                })
    }

    fun toggleStock(application: Application, itemId: String) {
        isStockUpdating.postValue(true)
        if (isStocking.value ?: false) {
            application.usecases.unstockItem(itemId).exec({
                isStocking.postValue(false)
            }, {
                errors.postValue(it)
            }, {
                isStockUpdating.postValue(false)
            })
        } else {
            application.usecases.stockItem(itemId).exec({
                isStocking.postValue(true)
            }, {
                errors.postValue(it)
            }, {
                isStockUpdating.postValue(false)
            })
        }
    }
}