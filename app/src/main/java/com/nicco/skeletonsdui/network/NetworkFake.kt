package com.nicco.skeletonsdui.network

import com.nicco.skeletonsdui.network.response.ComponentResponse
import com.nicco.skeletonsdui.network.response.SDUIResponse
import com.nicco.skeletonsdui.network.response.StylesResponse

class NetworkFake() {
    fun getSDUIcomponents(): SDUIResponse = retrofitGetServiceInWeb()

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