package com.self.categoryrevampprototype.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.self.categoryrevampprototype.R
import com.self.categoryrevampprototype.ui.dashboard.Communicator
import com.self.categoryrevampprototype.ui.dashboard.model.CategoryModel
import kotlinx.android.synthetic.main.row_category.view.*
import kotlinx.android.synthetic.main.row_sub_category.view.*
import kotlinx.android.synthetic.main.row_sub_category.view.tv_sub_cat_name
import kotlinx.android.synthetic.main.row_sub_category_child.view.*

class CategoryAdapter(private val list: List<CategoryModel>, val communicator: Communicator) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_CATEGORY = 0
        private const val TYPE_SUB_CATEGORY = 1
        private const val TYPE_SUB_CATEGORY_CHILD = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_CATEGORY -> CategoryViewHolder(parent)
            TYPE_SUB_CATEGORY -> SubCategoryViewHolder(parent)
            TYPE_SUB_CATEGORY_CHILD -> SubCategoryChildViewHolder(parent)
            else -> CategoryViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = list[position]
        when (holder) {
            is CategoryViewHolder -> holder.bind(element)
            is SubCategoryViewHolder -> holder.bind(element)
            is SubCategoryChildViewHolder -> holder.bind(element)
            else -> throw IllegalArgumentException("Does'nt support this view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            0 -> TYPE_CATEGORY
            1 -> TYPE_SUB_CATEGORY
            2 -> TYPE_SUB_CATEGORY_CHILD
            else -> TYPE_CATEGORY
        }
    }

    override fun getItemCount() = list.size


    inner class CategoryViewHolder(itemView: View) : BaseViewHolder<CategoryModel>(itemView) {

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_category,
                parent,
                false
            )
        )

        override fun bind(item: CategoryModel) {
            val cat = item.name.split(" ")
            itemView.tv_cat_name.text = item.name//cat[0] + "\n" + cat[1]
            itemView.rv_item.setOnClickListener {
                communicator.changePage(adapterPosition)
            }
        }
    }

    class SubCategoryViewHolder(itemView: View) : BaseViewHolder<CategoryModel>(itemView) {

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_sub_category,
                parent,
                false
            )
        )

        override fun bind(item: CategoryModel) {
            itemView.tv_sub_cat_name.text = item.name
        }
    }

    class SubCategoryChildViewHolder(itemView: View) : BaseViewHolder<CategoryModel>(itemView) {

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_sub_category_child,
                parent,
                false
            )
        )

        override fun bind(item: CategoryModel) {
            itemView.tv_sub_cat_child_name.text = item.name
        }
    }


}

