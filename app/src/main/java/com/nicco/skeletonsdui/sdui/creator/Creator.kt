package com.nicco.skeletonsdui.sdui.creator

import com.nicco.skeletonsdui.sdui.components.Component
import com.nicco.skeletonsdui.network.response.ComponentResponse
import com.nicco.skeletonsdui.sdui.components.EditText
import com.nicco.skeletonsdui.sdui.components.Picker
import com.nicco.skeletonsdui.sdui.components.TextView

class Creator {
    companion object {
        val TEXTVIEW = "TextView"
        val EDITTEXT = "EditText"
        val PICKER = "Picker"
    }

    fun createComponent(clazz: ComponentResponse): Component {
        return when (clazz.typeComponentResponse) {
            TEXTVIEW -> {
                TextView()
            }
            EDITTEXT -> {
                EditText()
            }
            PICKER -> {
                Picker()
            }
            else -> {
                TextView()
            }
        }
    }
}