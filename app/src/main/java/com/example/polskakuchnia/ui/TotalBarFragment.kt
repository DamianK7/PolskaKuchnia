package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.polskakuchnia.R
import com.example.polskakuchnia.databinding.FragmentTotalBarBinding
import com.example.polskakuchnia.viewmodel.OrderViewModel

class TotalBarFragment : Fragment(R.layout.fragment_total_bar) {

    private val viewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTotalBarBinding.bind(view)

        viewModel.currentTotal.observe(viewLifecycleOwner) { price ->
            binding.tvPrice.text = "Do zapłaty: %.2f zł".format(price)
        }
    }
}