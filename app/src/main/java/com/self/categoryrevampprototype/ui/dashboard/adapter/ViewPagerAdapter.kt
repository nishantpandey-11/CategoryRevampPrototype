package com.self.categoryrevampprototype.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.self.categoryrevampprototype.R
import com.self.categoryrevampprototype.ui.dashboard.Communicator
import com.self.categoryrevampprototype.ui.dashboard.model.CategoryModel
import com.self.categoryrevampprototype.ui.dashboard.model.subCategoryChildMensFashion
import com.self.categoryrevampprototype.ui.dashboard.model.subCategoryLargeAppliance
import kotlinx.android.synthetic.main.item_viewpager.view.*

class ViewPagerAdapter(
    private val categoryData: Map<CategoryModel, List<CategoryModel>>,
    private val categoryList: List<CategoryModel>,
    private val communicator: Communicator
) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_viewpager,
                parent,
                false
            )
        )

        fun bind(category: CategoryModel) {
            item.tvTitle.text = category.name
            item.rv_sub_cat.adapter = CategoryAdapter(
                categoryData.get(category) ?: subCategoryLargeAppliance,
                communicator
            )
            val childLayoutManager = GridLayoutManager(item.rv_sub_cat_child.context, 2)
            item.rv_sub_cat_child.apply {
                layoutManager = childLayoutManager
                adapter = CategoryAdapter(subCategoryChildMensFashion, communicator)
                /*addItemDecoration(
                    RecyclerItemDecorator(
                        resources.getDimension(R.dimen.padding_10dp).toInt(),
                        true
                    )
                )*/
            }
            item.tvTitle.setOnClickListener {
                communicator.pageClickListener(View.GONE)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
        //holder.bind(categoryData.keys.toList()[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
        //return categoryData.keys.toList().size
    }


}

