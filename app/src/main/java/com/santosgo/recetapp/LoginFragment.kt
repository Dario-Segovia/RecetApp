package com.santosgo.recetapp

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.appcompat.app.AppCompatDelegate
import com.santosgo.recetapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Establecer el texto del botón a través de la cadena de recursos
        binding.navigateButton.text = getString(R.string.continuar_button)  // Usa el texto desde los recursos de cadena

        binding.navigateButton.setOnClickListener {
            val nombreUser = binding.userInput.text.toString()

            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
            sharedPreferences.edit().putString("username", nombreUser).apply()

            val bundle = Bundle().apply {
                putString("Nombre", nombreUser)
            }

            findNavController().navigate(R.id.action_loginFragment_to_noticeFragment5, bundle)
        }

        binding.themeToggleButton.setOnClickListener {
            val currentMode = AppCompatDelegate.getDefaultNightMode()

            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                Toast.makeText(requireContext(), "Modo día activado", Toast.LENGTH_SHORT).show()
            } else {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                Toast.makeText(requireContext(), "Modo oscuro activado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
