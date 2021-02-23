package com.self.categoryrevampprototype.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.self.categoryrevampprototype.R
import com.self.categoryrevampprototype.ui.dashboard.adapter.CategoryAdapter
import com.self.categoryrevampprototype.ui.dashboard.adapter.ViewPagerAdapter
import com.self.categoryrevampprototype.ui.dashboard.model.categoryData
import com.self.categoryrevampprototype.ui.dashboard.model.categoryList
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(), Communicator {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vp.adapter = ViewPagerAdapter(categoryData, categoryList, this)
        TabLayoutMediator(tabs, vp) { tab, position ->
            tab.text = categoryList[position].name

        }.attach()

        val categoryAdapter = CategoryAdapter(categoryList, this)
        rv_cat.adapter = categoryAdapter


        vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                pageClickListener(View.VISIBLE)
            }

        })

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {

        })


    }

    override fun changePage(position: Int) {
        vp.setCurrentItem(position, true)
    }

    override fun pageClickListener(visiblity: Int) {
        rv_cat.visibility = visiblity
    }

  /*  override fun onResume() {
        super.onResume()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.show()
    }*/
}