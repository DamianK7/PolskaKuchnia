package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.polskakuchnia.R
import com.example.polskakuchnia.databinding.FragmentCustomMealBinding
import com.example.polskakuchnia.viewmodel.OrderViewModel

class CustomMealFragment : Fragment(R.layout.fragment_custom_meal) {

    private val viewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCustomMealBinding.bind(view)

        binding.btnIngChicken.setOnClickListener { viewModel.addItem("Filet z kurczaka", 14.0) }
        binding.btnIngMielony.setOnClickListener { viewModel.addItem("Kotlet mielony", 12.0) }
        binding.btnIngFish.setOnClickListener { viewModel.addItem("Ryba smażona", 18.0) }

        binding.btnSidePotatoes.setOnClickListener { viewModel.addItem("Ziemniaki", 6.0) }
        binding.btnSideGroats.setOnClickListener { viewModel.addItem("Kasza gryczana", 5.0) }
        binding.btnSideSalad.setOnClickListener { viewModel.addItem("Zestaw surówek", 5.0) }

        binding.btnDrinkCompote.setOnClickListener { viewModel.addItem("Kompot", 4.0) }
        binding.btnDrinkWater.setOnClickListener { viewModel.addItem("Woda", 3.0) }

        binding.btnAddToBill.setOnClickListener {
            viewModel.confirmPerson()
            Toast.makeText(context, "Skomponowane danie dodane!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack(R.id.menuChoiceFragment, false)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}