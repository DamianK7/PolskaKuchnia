package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.polskakuchnia.R
import com.example.polskakuchnia.databinding.FragmentMenuChoiceBinding

class MenuChoiceFragment : Fragment(R.layout.fragment_menu_choice) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMenuChoiceBinding.bind(view)

        binding.btnGoToReadyMeals.setOnClickListener {
            findNavController().navigate(R.id.readyMealFragment)
        }
    }
}