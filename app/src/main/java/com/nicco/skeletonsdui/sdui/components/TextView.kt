package com.nicco.skeletonsdui.sdui.components

import android.content.Context
import android.view.View
import android.widget.TextView
import com.nicco.skeletonsdui.sdui.validator.Validator

class TextView: Validator, Component() {
    override fun isValid(): Boolean {
        return true
    }

    override fun getView(context: Context): View {
        val textView = TextView(context)
        textView.text = "Hello World"
        return textView
    }
}