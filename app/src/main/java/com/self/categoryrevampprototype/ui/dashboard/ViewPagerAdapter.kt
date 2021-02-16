package com.self.categoryrevampprototype.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.self.categoryrevampprototype.R
import kotlinx.android.synthetic.main.item_viewpager.view.*

class ViewPagerAdapter(private val list: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_viewpager,
                parent,
                false
            )
        )

        fun bind(category: String) {
            item.tvTitle.text = category
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

