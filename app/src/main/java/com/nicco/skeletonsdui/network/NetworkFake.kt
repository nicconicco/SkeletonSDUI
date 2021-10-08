package com.nicco.skeletonsdui.network

import com.nicco.skeletonsdui.network.response.ComponentResponse
import com.nicco.skeletonsdui.network.response.SDUIResponse
import com.nicco.skeletonsdui.network.response.StylesResponse
import com.nicco.skeletonsdui.sdui.components.Component
import com.nicco.skeletonsdui.sdui.controller.SDUIController

class NetworkFake(private val sduiController: SDUIController) {
    fun getSDUIcomponents(): List<Component> {
        val response = retrofitGetServiceInWeb()

        return sduiController.createComponents(response)
    }

    private fun retrofitGetServiceInWeb(): SDUIResponse {
        //just a mock
        return SDUIResponse(
            state = "Success",
            components = createListFake()
        )
    }

    private fun createListFake(): List<ComponentResponse> {
        val list = mutableListOf<ComponentResponse>()

        list.add(
            ComponentResponse(
                typeComponentResponse = "EditText",
                validatorResponse = "isEmptyString",
                stylesResponse = StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "TextView",
                "NoValidator",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )
        list.add(
            ComponentResponse(
                "Picker",
                "SelectOneDefault",
                StylesResponse("#FFFFFF", "#000000")
            )
        )

        return list
    }
}