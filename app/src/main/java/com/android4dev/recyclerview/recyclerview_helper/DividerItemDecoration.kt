package com.android4dev.recyclerview.recyclerview_helper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v4.content.ContextCompat
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.drawable.Drawable

/***
 * Made by Lokesh Desai (Android4Dev)
 */
class DividerItemDecoration
/**
 * Default divider will be used
 */(context: Context) : RecyclerView.ItemDecoration() {
    private val ATTRS = intArrayOf(android.R.attr.listDivider)

    private var divider: Drawable? = null

    init {
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0)
        styledAttributes.recycle()
    }

    /**
     * Custom divider will be used
     */
    constructor(context: Context, resId: Int) : this(context) {
        divider = ContextCompat.getDrawable(context, resId)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight

            divider!!.setBounds(left, top, right, bottom)
            divider!!.draw(c)
        }
    }
}