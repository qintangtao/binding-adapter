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
    @BindingAdapter(value = ["primaryName", "secondaryName", "separator"], requireAll = false)
    fun setHtmlText(textView: TextView, primaryName: String?, secondaryName: String?, separator: String?) {
        textView.text = when {
            !primaryName.isNullOrEmpty() && !secondaryName.isNullOrEmpty() ->
                "${primaryName.htmlToSpanned()}${separator ?: '/'}${secondaryName.htmlToSpanned()}"
            !primaryName.isNullOrEmpty() && secondaryName.isNullOrEmpty() ->
                primaryName.htmlToSpanned()
            primaryName.isNullOrEmpty() && !secondaryName.isNullOrEmpty() ->
                secondaryName.htmlToSpanned()
            else -> ""
        }
    }
}