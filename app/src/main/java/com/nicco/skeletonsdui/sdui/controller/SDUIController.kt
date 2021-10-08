package com.nicco.skeletonsdui.sdui.controller

import com.nicco.skeletonsdui.network.response.SDUIResponse
import com.nicco.skeletonsdui.sdui.components.Component
import com.nicco.skeletonsdui.sdui.creator.Creator

class SDUIController {

    private val creator: Creator = Creator()

    lateinit var listComponentsSavedInMemory: List<Component>

    fun createComponents(componentResponse: SDUIResponse): List<Component> {
        val list = mutableListOf<Component>()

        val components = componentResponse.components

        for (element in components) {
            list.add(creator.createComponent(element))
        }

        listComponentsSavedInMemory = list.toMutableList()

        return list
    }
}