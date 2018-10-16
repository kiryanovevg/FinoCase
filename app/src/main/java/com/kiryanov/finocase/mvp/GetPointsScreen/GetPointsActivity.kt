package com.kiryanov.finocase.mvp.GetPointsScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.finocase.R
import com.kiryanov.finocase.RecyclerViewAdapter
import com.kiryanov.finocase.data.Model
import com.kiryanov.finocase.databinding.ActivityGetPointsBinding

class GetPointsActivity : MvpAppCompatActivity(), GetPointsView {

    private lateinit var adapter: RecyclerViewAdapter<Model, GetPointsPresenter>

    @InjectPresenter
    lateinit var presenter: GetPointsPresenter

    private lateinit var binding: ActivityGetPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_points)

        setSupportActionBar(binding.toolbar)
        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)

        adapter = RecyclerViewAdapter(R.layout.item_get_points, presenter)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter.addAll(object : ArrayList<Model>() {
            init {
                add(Model("Успеваемость", "Получи до 600 баллов за вовремя сданную сессию"))
                add(Model("Посещение пар", "Ходи на все пары и получай до 600 баллов"))
                add(Model("Научная деятельность", "Пиши статьи и участвуй в научных мероприятиях и получай до 400 баллов"))
                add(Model("Социальная активность", "Получай до 400 баллов за активную жизнь в ВУЗе"))
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