package com.nicco.skeletonsdui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.nicco.skeletonsdui.databinding.ActivityMainBinding
import com.nicco.skeletonsdui.presentation.SDUIViewModel
import com.nicco.skeletonsdui.sdui.components.Component

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var result: List<Component>
    private val viewModel: SDUIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        result = viewModel.getSDUIcomponents()
        binding.sduiView.setupView(result)
        binding.btnOutside.setOnClickListener {
            val snack = Snackbar.make(it,"This is a simple Snackbar",Snackbar.LENGTH_LONG)
            snack.show()
        }
    }
}