package me.tang.bindingadapter.banner

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

class BannerImageLoader : ImageLoader() {

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(imageView!!.context)
            .load(path as String)
            .into(imageView)
    }

}