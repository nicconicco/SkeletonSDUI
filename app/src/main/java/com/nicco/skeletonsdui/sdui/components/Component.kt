package com.nicco.skeletonsdui.sdui.components

import android.content.Context
import android.view.View

abstract class Component {

    open fun getView(context: Context): View = View(context)
}