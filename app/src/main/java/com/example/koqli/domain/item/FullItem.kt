package com.example.koqli.domain.item

import com.example.koqli.domain.comment.Comment
import java.io.Serializable

/**
 * Created by biwaishi on 2018/03/04.
 */

data class FullItem(private val item: Item, private val comments: List<Comment>): Serializable