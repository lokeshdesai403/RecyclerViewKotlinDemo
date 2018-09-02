package com.android4dev.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item_recycler_header.view.*

class HeaderViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun bindView(){
        itemView.textHeader.text="Header Section"
    }
}