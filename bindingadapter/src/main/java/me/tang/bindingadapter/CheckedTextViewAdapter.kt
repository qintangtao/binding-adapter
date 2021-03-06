package me.tang.bindingadapter

import android.widget.CheckedTextView
import androidx.databinding.BindingAdapter

object CheckedTextViewAdapter {

    @JvmStatic
    @BindingAdapter(value = ["state_checked"], requireAll = false)
    fun setChecked(view: CheckedTextView, checked: Boolean) {
        view.isChecked = checked
    }

}