package com.nicco.skeletonsdui.sdui.components

import android.content.Context
import android.view.View
import android.widget.EditText
import com.nicco.skeletonsdui.sdui.validator.Validator

class EditText: Validator, Component() {
    override fun isValid(): Boolean {
        return true
    }

    override fun getView(context: Context): View {
        val editText = EditText(context)
        editText.hint = "Just numbers are allowed"
        return editText
    }
}