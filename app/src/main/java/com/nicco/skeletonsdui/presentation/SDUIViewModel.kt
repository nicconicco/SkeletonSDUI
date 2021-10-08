package com.nicco.skeletonsdui.presentation

import androidx.lifecycle.ViewModel
import com.nicco.skeletonsdui.network.NetworkFake
import com.nicco.skeletonsdui.sdui.components.Component
import com.nicco.skeletonsdui.sdui.controller.SDUIController

class SDUIViewModel : ViewModel() {
    fun getSDUIcomponents(): List<Component> {
        return NetworkFake(SDUIController()).getSDUIcomponents()
    }
}