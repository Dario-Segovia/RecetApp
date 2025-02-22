package com.santosgo.recetapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santosgo.recetapp.databinding.FragmentRecetasBinding
import com.santosgo.recetapp.RecetasItem  // Importa el modelo de datos

class RecetaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = FragmentRecetasBinding.bind(view)

    fun render(
        recetasItem: RecetasItem,
        onClickListener: (RecetasItem) -> Unit,
        onFavoriteClick: (RecetasItem) -> Unit
    ) {
        binding.tvNombreReceta.text = recetasItem.nombre
        binding.tvOrigenReceta.text = recetasItem.Origen
        binding.tvTipoReceta.text = recetasItem.Tipo

        Glide.with(binding.ivReceta.context)
            .load(recetasItem.foto)
            .into(binding.ivReceta)

        itemView.setOnClickListener {
            onClickListener(recetasItem)
        }

        // Manejar el botón de favorito (agregar/quitar)
        binding.btnFavorito.setOnClickListener {
            onFavoriteClick(recetasItem)
        }
    }
}
