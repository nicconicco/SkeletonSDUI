package com.nicco.skeletonsdui.sdui.components

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.nicco.skeletonsdui.sdui.listener.Listener
import com.nicco.skeletonsdui.sdui.validator.Validator

class EditText : Validator, Component() {
    private lateinit var actionListener: Listener
    private lateinit var editText: EditText

    override fun isValid(): Boolean = editText.text.isNotEmpty()

    override fun getView(context: Context): View {
        editText = EditText(context)
        editText.hint = "Just numbers are allowed"
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                actionListener.onItemChanged()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                actionListener.onItemChanged()
            }

            override fun afterTextChanged(p0: Editable?) {
                actionListener.onItemChanged()
            }
        })

        return editText
    }

    override fun setObserableAction(action: Listener) {
        super.setObserableAction(action)
        actionListener = action
    }
}


