package com.nicco.skeletonsdui.sdui.viewcontroller

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import com.nicco.skeletonsdui.sdui.components.Component
import android.view.Gravity
import android.widget.LinearLayout


class SDUIViewController constructor(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    private lateinit var scrollView: ScrollView
    private lateinit var rootLayout: ConstraintLayout

    init {
        removeView(this)
        configureRootLayout()
    }

    private fun configureRootLayout() {
        rootLayout = ConstraintLayout(context)
        rootLayout.id = generateViewId()
        val constraintLayoutParams =
            LayoutParams(MATCH_PARENT, MATCH_PARENT)
        rootLayout.layoutParams = constraintLayoutParams
        addView(rootLayout)
    }

    fun setupView(listComponent: List<Component>) {
        rootLayout.addView(configureScrollView(rootLayout))

        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity = Gravity.CENTER

        for (element in listComponent) {
            linearLayout.addView(element.getView(context))
        }

        scrollView.addView(linearLayout)
    }

    private fun configureScrollView(rootViewGroup: ConstraintLayout): View? {
        val layoutParamsView = LayoutParams(
            MATCH_PARENT,
            MATCH_PARENT
        )
        layoutParamsView.startToStart = rootViewGroup.id
        layoutParamsView.topToTop = rootViewGroup.id
        layoutParamsView.bottomToBottom = rootViewGroup.id
        layoutParamsView.endToEnd = rootViewGroup.id

        val scrollView = ScrollView(context)
        scrollView.id = generateViewId()
        scrollView.layoutParams = layoutParamsView
        this.scrollView = scrollView

        return scrollView
    }
}