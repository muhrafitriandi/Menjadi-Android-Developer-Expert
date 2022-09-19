package com.yandey.core.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.yandey.core.R

fun ImageView.loadImage(context: Context, url: String?) {
    Glide
        .with(context)
        .load(url)
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.image_error)
        .into(this)
}