package com.santosgo.recetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.santosgo.recetapp.databinding.FragmentDetailItemBinding


class DetailItemFragment : Fragment() {



        private var _binding: FragmentDetailItemBinding? = null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val nombre = arguments?.getString("nombre")
            val tipo = arguments?.getString("tipo")
            val origen = arguments?.getString("origen")
            val foto = arguments?.getString("foto")

            binding.tvNombre.text = nombre
            binding.tvTipo.text = tipo
            binding.tvOrigen.text = origen

            Glide.with(this).load(foto).into(binding.ivFoto)
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


}