package com.santosgo.recetapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.santosgo.recetapp.adapter.RecetasAdapter
import com.santosgo.recetapp.adapter.RecetasViewModel
import com.santosgo.recetapp.databinding.FragmentFavoriteBinding

class FavItemListFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var viewModel: RecetasViewModel
    private lateinit var adapter: RecetasAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RecetasViewModel::class.java)
        initRecyclerView()

        viewModel.favoritos.observe(viewLifecycleOwner) { lista ->
            adapter = RecetasAdapter(lista, { receta ->
                val bundle = Bundle().apply {
                    putString("nombre", receta.nombre)
                    putString("tipo", receta.Tipo)
                    putString("origen", receta.Origen)
                    putString("foto", receta.foto)
                }
                requireActivity().findNavController(R.id.titulo)
                    .navigate(R.id.action_favoriteFragment_to_detailFavItemFragment22, bundle)
            }, { receta ->
                viewModel.eliminarFavorito(receta)
                Toast.makeText(context, getString(R.string.eliminado_favoritos, receta.nombre), Toast.LENGTH_SHORT).show()
            })
            binding.recyclerFavoritos.adapter = adapter
        }
    }

    private fun onItemSelected(receta: RecetasItem) {
        val bundle = Bundle().apply {
            putString("nombre", receta.nombre)
            putString("tipo", receta.Tipo)
            putString("origen", receta.Origen)
            putString("foto", receta.foto)
        }
        requireActivity().findNavController(R.id.titulo)
            .navigate(R.id.action_favoriteFragment_to_detailFavItemFragment22, bundle)
    }

    @SuppressLint("StringFormatInvalid")
    private fun initRecyclerView() {
        binding.recyclerFavoritos.layoutManager = LinearLayoutManager(context)
        viewModel.favoritos.observe(viewLifecycleOwner) { lista ->
            adapter = RecetasAdapter(lista, { receta ->
                onItemSelected(receta)
            }, { receta ->
                viewModel.eliminarFavorito(receta)
                Toast.makeText(context, getString(R.string.eliminado_favoritos, receta.nombre), Toast.LENGTH_SHORT).show()
            })
            binding.recyclerFavoritos.adapter = adapter
        }
    }
}
