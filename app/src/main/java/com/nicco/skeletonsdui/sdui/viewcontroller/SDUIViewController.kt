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
import com.nicco.skeletonsdui.sdui.listener.Listener


class SDUIViewController constructor(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    private lateinit var listComponentSavedInMemory: List<Component>
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

    fun setupView(listComponent: List<Component>, actionListener: Listener) {

        listComponentSavedInMemory = listComponent
        rootLayout.addView(configureScrollView(rootLayout))

        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity = Gravity.CENTER

        setComponentsInsideLinearLayout(actionListener, linearLayout)

        scrollView.addView(linearLayout)
    }

    private fun setComponentsInsideLinearLayout(
        actionListener: Listener,
        linearLayout: LinearLayout
    ) {
        for (element in listComponentSavedInMemory) {
            element.setObserableAction(actionListener)
            linearLayout.addView(element.getView(context))
        }
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

    fun validateComponents(): Boolean {
        val result = listComponentSavedInMemory.filter { !it.isValid() }

        return result.isEmpty()
    }
}