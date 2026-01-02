package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.polskakuchnia.R
import com.example.polskakuchnia.databinding.FragmentReadyMealBinding
import com.example.polskakuchnia.viewmodel.OrderViewModel

class ReadyMealFragment : Fragment(R.layout.fragment_ready_meal) {

    private val viewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReadyMealBinding.bind(view)

        binding.btnTomatoSoup.setOnClickListener {
            viewModel.setSoupPrice(12.0)
        }

        binding.btnBackToMenu.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}