package com.self.categoryrevampprototype.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.self.categoryrevampprototype.R
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class CategoryAdapter(private val list: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_recycler_view,
                parent,
                false
            )
        )

        fun bind(category: String) {
            val cat = category.split(" ")
            item.tv_cat_name.text = cat[0] + "\n" + cat[1]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

