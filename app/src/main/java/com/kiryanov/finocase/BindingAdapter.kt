package com.kiryanov.finocase

import android.databinding.BindingAdapter
import android.widget.ImageView

@BindingAdapter("android:res_src")
fun setImageResource(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}