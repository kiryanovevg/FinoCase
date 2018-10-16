package com.kiryanov.finocase.mvp.InfoScreen

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.finocase.R
import com.kiryanov.finocase.databinding.FragmentInfoBinding
import com.kiryanov.finocase.mvp.GetPointsScreen.GetPointsActivity
import com.kiryanov.finocase.mvp.PartnersScreen.PartnersActivity
import com.kiryanov.finocase.mvp.SpendPointsScreen.SpendPointsActivity

class InfoFragment : MvpAppCompatFragment(), InfoView {

    @InjectPresenter
    lateinit var presenter: InfoPresenter

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        binding.getPoints.setOnClickListener {
            startActivity(Intent(context, GetPointsActivity::class.java))
        }

        binding.spendPoints.setOnClickListener{
            startActivity(Intent(context, SpendPointsActivity::class.java))
        }

        binding.partners.setOnClickListener{
            startActivity(Intent(context, PartnersActivity::class.java))
        }

        return binding.root
    }
}