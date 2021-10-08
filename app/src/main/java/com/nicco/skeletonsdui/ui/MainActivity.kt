package com.nicco.skeletonsdui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
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

        binding.btnOutside.setOnClickListener {
            if (binding.sduiView.validateComponents()) {
                val snack = Snackbar.make(it, "validateComponents", Snackbar.LENGTH_LONG)
                snack.show()
            }
        }
    }

    private fun onItemChangedMainActivity() {
        Log.d("working", "onItemChangedMainActivity")
    }
}