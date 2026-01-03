package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
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


        binding.btnTomatoSoup.setOnClickListener { viewModel.addItem("Pomidorowa", 12.0) }

        binding.btnRosol.setOnClickListener { viewModel.addItem("Rosół", 10.0) }

        binding.btnSchabowy.setOnClickListener { viewModel.addItem("Schabowy", 28.0) }

        binding.btnPierogi.setOnClickListener { viewModel.addItem("Pierogi", 22.0) }

        binding.btnCola.setOnClickListener { viewModel.addItem("Cola", 8.0) }

        binding.btnKompot.setOnClickListener { viewModel.addItem("Kompot", 5.0) }


        binding.btnAddToBill.setOnClickListener {
            viewModel.confirmPerson()
            Toast.makeText(context, "Dodano osobę do rachunku!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}