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

    @JvmStatic
    @BindingAdapter(value = ["primaryHtml", "secondaryHtml", "separatorHtml"], requireAll = false)
    fun setHtmlText(textView: TextView, primaryHtml: String?, secondaryHtml: String?, separatorHtml: String?) {
        textView.text = when {
            !primaryHtml.isNullOrEmpty() && !secondaryHtml.isNullOrEmpty() ->
                "${primaryHtml.htmlToSpanned()}${separatorHtml ?: '/'}${secondaryHtml.htmlToSpanned()}"
            !primaryHtml.isNullOrEmpty() && secondaryHtml.isNullOrEmpty() ->
                primaryHtml.htmlToSpanned()
            primaryHtml.isNullOrEmpty() && !secondaryHtml.isNullOrEmpty() ->
                secondaryHtml.htmlToSpanned()
            else -> ""
        }
    }
}