package com.kiryanov.finocase.mvp.SpendPointsScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.finocase.R
import com.kiryanov.finocase.RecyclerViewAdapter
import com.kiryanov.finocase.data.Shop
import com.kiryanov.finocase.databinding.ActivitySpendPointsBinding

class SpendPointsActivity : MvpAppCompatActivity(), SpendPointsView {

    private lateinit var adapter: RecyclerViewAdapter<Shop, SpendPointsPresenter>

    @InjectPresenter
    lateinit var presenter: SpendPointsPresenter

    private lateinit var binding: ActivitySpendPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spend_points)

        setSupportActionBar(binding.toolbar)
        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)

        adapter = RecyclerViewAdapter(R.layout.item_shop, presenter)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.addAll(object : ArrayList<Shop>() {
            init {
                add(Shop(""))
                add(Shop(""))
                add(Shop(""))
                add(Shop(""))
                add(Shop(""))
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }
}