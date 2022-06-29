package me.tang.bindingadapter.textview

import android.widget.TextView
import androidx.databinding.BindingAdapter
import me.tang.bindingadapter.ext.htmlToSpanned

object TextViewAdapter {

    @JvmStatic
    @BindingAdapter(value = ["html"], requireAll = false)
    fun setHtmlText(textView: TextView, text: String?) {
        text?.let {
            textView.text = it.htmlToSpanned()
        }
    }

}