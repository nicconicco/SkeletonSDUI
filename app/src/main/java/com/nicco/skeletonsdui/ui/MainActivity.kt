package com.nicco.skeletonsdui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.nicco.skeletonsdui.R
import com.nicco.skeletonsdui.databinding.ActivityMainBinding
import com.nicco.skeletonsdui.presentation.SDUIViewModel
import com.nicco.skeletonsdui.sdui.components.Component
import com.nicco.skeletonsdui.sdui.listener.Listener

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

        binding.sduiView.setupView(result, object : Listener {
            override fun onItemChanged() {
                onItemChangedMainActivity()
            }
        })
    }

    private fun onItemChangedMainActivity() {
        if (binding.sduiView.validateComponents()) {
            binding.btnOutside.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        } else {
            binding.btnOutside.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }
    }
}