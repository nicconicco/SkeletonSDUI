package com.nicco.skeletonsdui.network.response

data class SDUIResponse(
    val state: String, val components: List<ComponentResponse>
)

data class ComponentResponse(
    val typeComponentResponse: String, val validatorResponse: String, val stylesResponse: StylesResponse
)

data class StylesResponse(
    val backgroundResponse: String, val colorTextResponse: String
)