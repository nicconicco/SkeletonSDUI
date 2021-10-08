package com.nicco.skeletonsdui.sdui.components

import android.content.Context
import android.view.View
import com.nicco.skeletonsdui.sdui.listener.Listener
import com.nicco.skeletonsdui.sdui.validator.Validator

abstract class Component: Validator {

    open fun getView(context: Context): View = View(context)

    open fun setObserableAction(action: Listener) {}
}