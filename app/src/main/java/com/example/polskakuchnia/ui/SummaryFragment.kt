package com.example.polskakuchnia.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.polskakuchnia.R
import com.example.polskakuchnia.databinding.FragmentSummaryBinding
import com.example.polskakuchnia.viewmodel.OrderViewModel

class SummaryFragment : Fragment(R.layout.fragment_summary) {

    private val viewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSummaryBinding.bind(view)

        viewModel.orderState.observe(viewLifecycleOwner) { orderObject ->
            val orders = orderObject.ordersList
            if (orders.isEmpty()) {
                binding.tvOrderDetails.text = "Brak zamówień. Koszyk jest pusty."
            } else {
                val sb = StringBuilder()
                orders.forEachIndexed { index, person ->
                    sb.append("OSOBA ${index + 1}:\n")
                    person.items.forEach { item ->
                        val line = String.format(" - %-20s %6.2f zł", item.name, item.price)
                        sb.append(line + "\n")
                    }
                    sb.append("   Suma osoby: ${String.format("%.2f", person.total())} zł\n")
                    sb.append("- - - - - - - - - - - - - -\n")
                }
                binding.tvOrderDetails.text = sb.toString()
            }
        }

        viewModel.grandTotal.observe(viewLifecycleOwner) { total ->
            binding.tvFinalSum.text = "RAZEM: ${String.format("%.2f", total)} zł"
        }

        binding.btnClear.setOnClickListener {
            viewModel.clearAll()
            Toast.makeText(context, "Wyczyszczono!", Toast.LENGTH_SHORT).show()
        }

        binding.btnPlaceOrder.setOnClickListener {
            if (viewModel.grandTotal.value == 0.0) {
                Toast.makeText(context, "Brak zamówień do opłacenia", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Zamówienie wysłane do kuchni!", Toast.LENGTH_LONG).show()
                viewModel.clearAll()
                findNavController().navigate(R.id.startFragment)
            }
        }

        binding.btnNewOrder.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
            bottomNav.selectedItemId = R.id.menuChoiceFragment
        }
    }
}