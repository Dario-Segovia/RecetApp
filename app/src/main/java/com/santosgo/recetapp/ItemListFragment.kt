package com.santosgo.recetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.santosgo.recetapp.adapter.RecetasAdapter
import com.santosgo.recetapp.adapter.RecetasViewModel
import com.santosgo.recetapp.databinding.FragmentHomeBinding

class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: RecetasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel = ViewModelProvider(requireActivity()).get(RecetasViewModel::class.java)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(context)
        binding.recyclerRecetas.layoutManager = manager
        binding.recyclerRecetas.adapter = RecetasAdapter(
            RecetasProvider.listaRecetas,
            { receta -> onItemSelected(receta) },
            { receta -> onFavoriteSelected(receta) }
        )
    }


    private fun onFavoriteSelected(receta: RecetasItem) {
        viewModel.agregarFavorito(receta)
        Toast.makeText(context, "Añadido a favoritos: ${receta.nombre}", Toast.LENGTH_SHORT).show()
    }


    private fun onItemSelected(receta: RecetasItem) {
        val bundle = Bundle().apply {
            putString("nombre", receta.nombre)
            putString("tipo", receta.Tipo)
            putString("origen", receta.Origen)
            putString("foto", receta.foto)
        }
        findNavController().navigate(R.id.action_homeFragment_to_detailItemFragment2, bundle)
    }

}
