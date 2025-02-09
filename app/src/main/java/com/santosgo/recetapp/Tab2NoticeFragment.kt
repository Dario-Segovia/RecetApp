package com.santosgo.recetapp

import android.os.Bundle
import android.util.Log
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

    ): View? {




        _binding = FragmentTab2NoticeBinding.inflate(inflater, container, false)


        val nombreUser = arguments?.getString("Nombre") ?: "Usuario"


        binding.tvTab2.text = "Bienvenido, $nombreUser"


        binding.btnSalir.setOnClickListener {

            findNavController().navigate(R.id.action_tab2NoticeFragment_to_loginFragment)
        }
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
