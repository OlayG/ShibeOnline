package com.olayg.shibeonline.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.view(url: String) {
    Glide.with(fragment)
        .load(url)
        .into(imageView);
}