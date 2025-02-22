package com.santosgo.recetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.santosgo.recetapp.databinding.FragmentTab2NoticeBinding

class Tab2NoticeFragment : Fragment() {

    private var _binding: FragmentTab2NoticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTab2NoticeBinding.inflate(inflater, container, false)

        // Obtener el nombre de usuario de los argumentos o usar el valor por defecto
        val nombreUser = arguments?.getString("Nombre") ?: getString(R.string.default_user)

        // Establecer el texto del mensaje de bienvenida
        binding.tvTab2.text = getString(R.string.welcome_message, nombreUser)

        // Establecer los textos de los botones
        binding.btnSalir.text = getString(R.string.btn_exit)
        binding.btnComenzar.text = getString(R.string.btn_start)

        // Navegación al fragmento de login cuando se presiona el botón "Salir"
        binding.btnSalir.setOnClickListener {
            findNavController().navigate(R.id.action_tab2NoticeFragment_to_loginFragment)
        }

        // Navegación al fragmento principal cuando se presiona el botón "Comenzar"
        binding.btnComenzar.setOnClickListener {
            findNavController().navigate(R.id.action_noticeFragment5_to_principalFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
