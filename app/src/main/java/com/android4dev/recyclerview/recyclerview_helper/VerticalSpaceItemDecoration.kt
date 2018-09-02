package com.android4dev.recyclerview.recyclerview_helper

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/***
 * Made by Lokesh Desai (Android4Dev)
 */
class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        outRect.bottom = verticalSpaceHeight
    }
}