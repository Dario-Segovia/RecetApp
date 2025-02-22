package com.santosgo.recetapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.santosgo.recetapp.databinding.FragmentDetailFavItemBinding

class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!

    private val COMMENTS_KEY = "comentarios_guardados"
    private val COMMENT_COUNT_KEY = "comentarios_count"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombre = arguments?.getString("nombre") ?: getString(R.string.sin_nombre)
        val tipo = arguments?.getString("tipo") ?: getString(R.string.sin_tipo)
        val origen = arguments?.getString("origen") ?: getString(R.string.sin_origen)
        val foto = arguments?.getString("foto")

        binding.tvNombre.text = nombre
        binding.tvTipo.text = tipo
        binding.tvOrigen.text = origen
        Glide.with(this).load(foto).into(binding.ivFoto)

        val sharedPreferences = requireActivity().getSharedPreferences("RecetApp", Context.MODE_PRIVATE)
        val comentariosGuardados = sharedPreferences.getString(COMMENTS_KEY, "")
        val contadorComentarios = sharedPreferences.getInt(COMMENT_COUNT_KEY, 0)

        binding.tvComentarios.text = comentariosGuardados

        binding.fabAddComment.setOnClickListener {
            val comentario = binding.etComentario.text.toString()
            if (comentario.isNotEmpty()) {
                val nuevoContador = contadorComentarios + 1
                val comentarioFormateado = getString(R.string.comentario_formato, nuevoContador, comentario)
                val nuevosComentarios = binding.tvComentarios.text.toString() + "\n" + comentarioFormateado

                sharedPreferences.edit()
                    .putString(COMMENTS_KEY, nuevosComentarios)
                    .putInt(COMMENT_COUNT_KEY, nuevoContador)
                    .apply()

                binding.tvComentarios.text = nuevosComentarios
                binding.etComentario.setText("")
                Toast.makeText(requireContext(), getString(R.string.comentario_guardado), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), getString(R.string.escribe_comentario), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBorrarComentarios.setOnClickListener {
            sharedPreferences.edit()
                .remove(COMMENTS_KEY)
                .remove(COMMENT_COUNT_KEY)
                .apply()

            binding.tvComentarios.text = ""
            Toast.makeText(requireContext(), getString(R.string.comentarios_borrados), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
